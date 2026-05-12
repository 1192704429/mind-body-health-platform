package com.psychology.api.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.psychology.api.dao.TeachersDao;
import com.psychology.api.dto.TeachersDTO;
import com.psychology.api.service.TeachersService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 老师管理业务层实现类
* @author: wuming
* @create: 2023.04.15 16:26:32
*/
@Service("teachersService")
public class TeachersServiceImpl extends ServiceImpl<TeachersDao, TeachersDTO> implements TeachersService {

    @Override
    public Page<TeachersDTO> basePage(TeachersDTO teachersDTO) {
        if (null != teachersDTO.getCurrent() && null != teachersDTO.getPageSize())
            teachersDTO.setCurrent((teachersDTO.getCurrent() - 1) * teachersDTO.getPageSize());
        List<TeachersDTO> list = this.baseMapper.findList(teachersDTO);
        int count = this.baseMapper.findPageCount(teachersDTO);
        Page<TeachersDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<TeachersDTO> findList(TeachersDTO teachersDTO) {
        return this.baseMapper.findList(teachersDTO);
    }

}
