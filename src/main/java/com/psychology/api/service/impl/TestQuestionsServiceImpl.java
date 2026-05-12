package com.psychology.api.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.psychology.api.dao.TestQuestionsDao;
import com.psychology.api.dto.TestQuestionsDTO;
import com.psychology.api.service.TestQuestionsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 试卷题目业务层实现类
* @author: wuming
* @create: 2023.04.15 16:26:32
*/
@Service("testQuestionsService")
public class TestQuestionsServiceImpl extends ServiceImpl<TestQuestionsDao, TestQuestionsDTO> implements TestQuestionsService {

    @Override
    public Page<TestQuestionsDTO> basePage(TestQuestionsDTO testQuestionsDTO) {
        if (null != testQuestionsDTO.getCurrent() && null != testQuestionsDTO.getPageSize())
            testQuestionsDTO.setCurrent((testQuestionsDTO.getCurrent() - 1) * testQuestionsDTO.getPageSize());
        List<TestQuestionsDTO> list = this.baseMapper.findList(testQuestionsDTO);
        int count = this.baseMapper.findPageCount(testQuestionsDTO);
        Page<TestQuestionsDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<TestQuestionsDTO> findList(TestQuestionsDTO testQuestionsDTO) {
        return this.baseMapper.findList(testQuestionsDTO);
    }

}
