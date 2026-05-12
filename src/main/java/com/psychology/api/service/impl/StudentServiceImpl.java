package com.psychology.api.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.psychology.api.dao.StudentDao;
import com.psychology.api.dto.StudentDTO;
import com.psychology.api.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 学生表业务层实现类
* @author: wuming
* @create: 2023.04.15 16:26:32
*/
@Service("studentService")
public class StudentServiceImpl extends ServiceImpl<StudentDao, StudentDTO> implements StudentService {

    @Override
    public Page<StudentDTO> basePage(StudentDTO studentDTO) {
        if (null != studentDTO.getCurrent() && null != studentDTO.getPageSize())
            studentDTO.setCurrent((studentDTO.getCurrent() - 1) * studentDTO.getPageSize());
        List<StudentDTO> list = this.baseMapper.findList(studentDTO);
        int count = this.baseMapper.findPageCount(studentDTO);
        Page<StudentDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<StudentDTO> findList(StudentDTO studentDTO) {
        return this.baseMapper.findList(studentDTO);
    }

}
