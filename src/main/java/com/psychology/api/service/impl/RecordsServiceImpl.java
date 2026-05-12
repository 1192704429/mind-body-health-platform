package com.psychology.api.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.psychology.api.dao.RecordsDao;
import com.psychology.api.dto.RecordsDTO;
import com.psychology.api.service.RecordsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 建档信息业务层实现类
* @author: wuming
* @create: 2023.04.15 16:26:32
*/
@Service("recordsService")
public class RecordsServiceImpl extends ServiceImpl<RecordsDao, RecordsDTO> implements RecordsService {

    @Override
    public Page<RecordsDTO> basePage(RecordsDTO recordsDTO) {
        if (null != recordsDTO.getCurrent() && null != recordsDTO.getPageSize())
            recordsDTO.setCurrent((recordsDTO.getCurrent() - 1) * recordsDTO.getPageSize());
        List<RecordsDTO> list = this.baseMapper.findList(recordsDTO);
        int count = this.baseMapper.findPageCount(recordsDTO);
        Page<RecordsDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<RecordsDTO> findList(RecordsDTO recordsDTO) {
        return this.baseMapper.findList(recordsDTO);
    }

}
