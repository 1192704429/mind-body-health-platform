package com.psychology.api.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.psychology.api.common.BaseController;
import com.psychology.api.common.ReturnMsg;
import com.psychology.api.common.util.MailUtil;
import com.psychology.api.dto.RecordsDTO;
import com.psychology.api.dto.StudentDTO;
import com.psychology.api.dto.TeachersDTO;
import com.psychology.api.dto.TestRulesDTO;
import com.psychology.api.service.RecordsService;
import com.psychology.api.service.StudentService;
import com.psychology.api.service.TeachersService;
import com.psychology.api.service.TestRulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @description: 建档信息对外接口层
 * @author: wuming
 * @create: 2023.04.15 16:26:32
 */
@RestController
@RequestMapping("/records")
public class RecordsController extends BaseController<RecordsService, RecordsDTO> {


    @Override
    @Resource(name = "recordsService")
    protected void setBaseService(RecordsService recordsService) {
        this.baseService = recordsService;
    }

    /**
     * 默认分页查询
     *
     * @param recordsDTO
     * @return
     */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody RecordsDTO recordsDTO) {
        return ReturnMsg.ok(baseService.basePage(recordsDTO));
    }

    /**
     * 根据XML中的sql语句进行查询
     *
     * @param recordsDTO
     * @return
     */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody RecordsDTO recordsDTO) {
        return ReturnMsg.ok(baseService.findList(recordsDTO));
    }

    @Override
    protected void beforeSave(RecordsDTO entity) throws Exception {

        super.beforeSave(entity);
    }

    @Autowired
    private TestRulesService testRulesService;

    @Autowired
    private MailUtil mailUtil;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeachersService teachersService;

    @PostMapping(value = "/saveGrade")
    public ReturnMsg saveGrade(@RequestBody RecordsDTO recordsDTO) {

        // 拿到规则
        LambdaQueryWrapper<TestRulesDTO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(TestRulesDTO::getTestId, recordsDTO.getTestId());
        List<TestRulesDTO> serviceList = testRulesService.list(queryWrapper);
        if (CollectionUtil.isEmpty(serviceList)) {
            return ReturnMsg.ok("您的得分为：" + recordsDTO.getGrade());
        }
        String title = "";
        String teacherTitle = "";
        StudentDTO stu = studentService.getById(recordsDTO.getStuId());
        TeachersDTO teachersDTO = teachersService.getById(recordsDTO.getTeaId());
        for (TestRulesDTO testRulesDTO : serviceList) {
            if (Integer.parseInt(recordsDTO.getGrade()) >= testRulesDTO.getMinGrade() && Integer.parseInt(recordsDTO.getGrade()) < testRulesDTO.getMaxGrade()) {
                title = "您的得分为：" + recordsDTO.getGrade() + ";心理老师给您的反馈为：" + testRulesDTO.getInfo();
                teacherTitle = "系统提醒,学生：" + stu.getStuName() + "完成心理测评，分数为：" + recordsDTO.getGrade() + "，试卷分数响应结果为：" + testRulesDTO.getInfo() + "，请您注意即时处理!";
                break;
            }
        }
        recordsDTO.setCreateTime(new Date());
        recordsDTO.setInfo(title);
        baseService.save(recordsDTO);
        // 邮件发送
        String finalTeacherTitle = teacherTitle;
        new Thread(() -> {
            mailUtil.sendSimpleMail(teachersDTO.getMail(), "学生测评消息提醒", finalTeacherTitle);
        }).start();
        return ReturnMsg.ok(title);
    }


}

