package com.psychology.api.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.psychology.api.dao.TestPaperDao;
import com.psychology.api.dto.TestPaperDTO;
import com.psychology.api.service.TestPaperService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 试卷管理业务层实现类
* @author: wuming
* @create: 2023.04.15 16:26:32
*/
@Service("testPaperService")
public class TestPaperServiceImpl extends ServiceImpl<TestPaperDao, TestPaperDTO> implements TestPaperService {

    @Override
    public Page<TestPaperDTO> basePage(TestPaperDTO testPaperDTO) {
        if (null != testPaperDTO.getCurrent() && null != testPaperDTO.getPageSize())
            testPaperDTO.setCurrent((testPaperDTO.getCurrent() - 1) * testPaperDTO.getPageSize());
        List<TestPaperDTO> list = this.baseMapper.findList(testPaperDTO);
        int count = this.baseMapper.findPageCount(testPaperDTO);
        Page<TestPaperDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<TestPaperDTO> findList(TestPaperDTO testPaperDTO) {
        return this.baseMapper.findList(testPaperDTO);
    }

}
