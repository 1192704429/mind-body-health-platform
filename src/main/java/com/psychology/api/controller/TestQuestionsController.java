package com.psychology.api.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.psychology.api.common.BaseController;
import com.psychology.api.common.BaseSelectEntity;
import com.psychology.api.common.ReturnMsg;
import com.psychology.api.dto.QuestionsDTO;
import com.psychology.api.dto.TestPaperDTO;
import com.psychology.api.dto.TestQuestionsDTO;
import com.psychology.api.service.QuestionsService;
import com.psychology.api.service.TestPaperService;
import com.psychology.api.service.TestQuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: 试卷题目对外接口层
 * @author: wuming
 * @create: 2023.04.15 16:26:32
 */
@RestController
@RequestMapping("/testQuestions")
public class TestQuestionsController extends BaseController<TestQuestionsService, TestQuestionsDTO> {

    @Autowired
    private TestPaperService testPaperService;
    @Autowired
    private QuestionsService questionsService;


    @Override
    @Resource(name = "testQuestionsService")
    protected void setBaseService(TestQuestionsService testQuestionsService) {
        this.baseService = testQuestionsService;
    }

    /**
     * 默认分页查询
     *
     * @param testQuestionsDTO
     * @return
     */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody TestQuestionsDTO testQuestionsDTO) {
        return ReturnMsg.ok(baseService.basePage(testQuestionsDTO));
    }

    @Override
    protected void afterSave(TestQuestionsDTO entity) throws Exception {
        Long id = entity.getTestId();
        QuestionsDTO questionsServiceById = questionsService.getById(entity.getQuestionId());
        TestPaperDTO id1 = testPaperService.getById(id);
        if (id1.getTotalGrade() == null) {
           // id1.setTotalGrade(questionsServiceById.getGrade());

        } else {
           // id1.setTotalGrade("" + (Integer.parseInt(id1.getTotalGrade()) + Integer.parseInt(questionsServiceById.getGrade())));
        }
        testPaperService.updateById(id1);
        super.afterSave(entity);
    }

    /**
     * 根据XML中的sql语句进行查询
     *
     * @param testQuestionsDTO
     * @return
     */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody TestQuestionsDTO testQuestionsDTO) {
        return ReturnMsg.ok(baseService.findList(testQuestionsDTO));
    }


    @PostMapping(value = "/allQuestion")
    public ReturnMsg allQuestion(@RequestBody TestQuestionsDTO testQuestionsDTO) {
        List<TestQuestionsDTO> serviceList = baseService.findList(testQuestionsDTO);
        if (CollectionUtil.isEmpty(serviceList)) return ReturnMsg.ok(new ArrayList<>());
        List<Long> longs = serviceList.stream().map(item -> item.getQuestionId()).collect(Collectors.toList());
        List<QuestionsDTO> questionsDTOS = questionsService.listByIds(longs);
        return ReturnMsg.ok(questionsDTOS);
    }


    @GetMapping("/all/testPaper/{teaId}")
    public ReturnMsg allTestPaper(@PathVariable("teaId") Long teaId) {
        List<BaseSelectEntity> list = new ArrayList<>();
        LambdaQueryWrapper<TestPaperDTO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(TestPaperDTO::getTeaId, teaId);
        List<TestPaperDTO> dtos = testPaperService.list(queryWrapper);
        for (TestPaperDTO dto : dtos) {
            BaseSelectEntity baseSelectEntity = new BaseSelectEntity();
            baseSelectEntity.setKey(dto.getId());
            baseSelectEntity.setValue(dto.getTitle());
            list.add(baseSelectEntity);
        }
        return ReturnMsg.ok(list);
    }

    @GetMapping("/all/questions/{teaId}")
    public ReturnMsg allQuestions(@PathVariable("teaId") Long teaId) {
        List<BaseSelectEntity> list = new ArrayList<>();
        LambdaQueryWrapper<QuestionsDTO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(QuestionsDTO::getTeacherId, teaId);
        List<QuestionsDTO> dtos = questionsService.list(queryWrapper);
        for (QuestionsDTO dto : dtos) {
            BaseSelectEntity baseSelectEntity = new BaseSelectEntity();
            baseSelectEntity.setKey(dto.getId());
            baseSelectEntity.setValue(dto.getId() + "：" +dto.getTitle());
            list.add(baseSelectEntity);
        }
        return ReturnMsg.ok(list);
    }

}

