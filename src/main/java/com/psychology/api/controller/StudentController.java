package com.psychology.api.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.psychology.api.common.BaseController;
import com.psychology.api.common.ReturnMsg;
import com.psychology.api.dto.StudentDTO;
import com.psychology.api.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: 学生表对外接口层
 * @author: wuming
 * @create: 2023.04.15 16:26:32
 */
@RestController
@RequestMapping("/student")
public class StudentController extends BaseController<StudentService, StudentDTO> {


    @Override
    @Resource(name = "studentService")
    protected void setBaseService(StudentService studentService) {
        this.baseService = studentService;
    }

    /**
     * 默认分页查询
     *
     * @param studentDTO
     * @return
     */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody StudentDTO studentDTO) {
        return ReturnMsg.ok(baseService.basePage(studentDTO));
    }

    /**
     * 根据XML中的sql语句进行查询
     *
     * @param studentDTO
     * @return
     */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody StudentDTO studentDTO) {
        return ReturnMsg.ok(baseService.findList(studentDTO));
    }


    @PostMapping(value = "/login")
    public ReturnMsg login(@RequestBody StudentDTO usersDTO) throws Exception {
        List<StudentDTO> usersDTOS = baseService.findList(usersDTO);
        if (CollectionUtil.isEmpty(usersDTOS)) throw new Exception("账号或密码有误!");
        return ReturnMsg.ok(usersDTOS.get(0));
    }

    @PostMapping(value = "/register")
    public ReturnMsg register(@RequestBody StudentDTO usersDTO) throws Exception {
        StudentDTO usersDTO1 = new StudentDTO();
        usersDTO1.setStuPhone(usersDTO.getStuPhone());
        List<StudentDTO> usersDTOS = baseService.findList(usersDTO1);
        if (CollectionUtil.isNotEmpty(usersDTOS)) throw new Exception("当前账号已经注册,不呢重复注册!");
        usersDTO.setStuName("学生" + usersDTO.getStuPhone());
        this.baseService.save(usersDTO);
        return ReturnMsg.ok();
    }


}

