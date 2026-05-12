package com.psychology.api.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.psychology.api.dao.QuestionsDao;
import com.psychology.api.dto.QuestionsDTO;
import com.psychology.api.service.QuestionsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 试题管理业务层实现类
* @author: wuming
* @create: 2023.04.15 16:26:32
*/
@Service("questionsService")
public class QuestionsServiceImpl extends ServiceImpl<QuestionsDao, QuestionsDTO> implements QuestionsService {

    @Override
    public Page<QuestionsDTO> basePage(QuestionsDTO questionsDTO) {
        if (null != questionsDTO.getCurrent() && null != questionsDTO.getPageSize())
            questionsDTO.setCurrent((questionsDTO.getCurrent() - 1) * questionsDTO.getPageSize());
        List<QuestionsDTO> list = this.baseMapper.findList(questionsDTO);
        int count = this.baseMapper.findPageCount(questionsDTO);
        Page<QuestionsDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<QuestionsDTO> findList(QuestionsDTO questionsDTO) {
        return this.baseMapper.findList(questionsDTO);
    }

}
