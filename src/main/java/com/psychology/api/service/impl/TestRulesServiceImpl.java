package com.psychology.api.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.psychology.api.dao.TestRulesDao;
import com.psychology.api.dto.TestRulesDTO;
import com.psychology.api.service.TestRulesService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 试卷规则管理业务层实现类
* @author: wuming
* @create: 2023.04.15 16:26:32
*/
@Service("testRulesService")
public class TestRulesServiceImpl extends ServiceImpl<TestRulesDao, TestRulesDTO> implements TestRulesService {

    @Override
    public Page<TestRulesDTO> basePage(TestRulesDTO testRulesDTO) {
        if (null != testRulesDTO.getCurrent() && null != testRulesDTO.getPageSize())
            testRulesDTO.setCurrent((testRulesDTO.getCurrent() - 1) * testRulesDTO.getPageSize());
        List<TestRulesDTO> list = this.baseMapper.findList(testRulesDTO);
        int count = this.baseMapper.findPageCount(testRulesDTO);
        Page<TestRulesDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<TestRulesDTO> findList(TestRulesDTO testRulesDTO) {
        return this.baseMapper.findList(testRulesDTO);
    }

}
