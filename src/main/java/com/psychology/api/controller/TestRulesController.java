package com.psychology.api.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.psychology.api.common.BaseController;
import com.psychology.api.common.BaseSelectEntity;
import com.psychology.api.common.ReturnMsg;
import com.psychology.api.dto.TestPaperDTO;
import com.psychology.api.dto.TestRulesDTO;
import com.psychology.api.service.TestPaperService;
import com.psychology.api.service.TestRulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description: 试卷规则管理对外接口层
 * @author: wuming
 * @create: 2023.04.15 16:26:32
 */
@RestController
@RequestMapping("/testRules")
public class TestRulesController extends BaseController<TestRulesService, TestRulesDTO> {

    @Autowired
    private TestPaperService testPaperService;

    @Override
    @Resource(name = "testRulesService")
    protected void setBaseService(TestRulesService testRulesService) {
        this.baseService = testRulesService;
    }

    /**
     * 默认分页查询
     *
     * @param testRulesDTO
     * @return
     */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody TestRulesDTO testRulesDTO) {
        return ReturnMsg.ok(baseService.basePage(testRulesDTO));
    }

    /**
     * 根据XML中的sql语句进行查询
     *
     * @param testRulesDTO
     * @return
     */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody TestRulesDTO testRulesDTO) {
        return ReturnMsg.ok(baseService.findList(testRulesDTO));
    }

    @Override
    protected void beforeSave(TestRulesDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
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

}

