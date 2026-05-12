package com.psychology.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.psychology.api.dto.TeachersDTO;
import java.util.List;
/**
* @description: 老师管理业务层接口
* @author: wuming
* @create: 2023.04.15 16:26:32
*/
public interface TeachersService extends IService<TeachersDTO> {

    /**
    * 默认分页方法
    * @param teachersDTO
    * @return
    */
    Page<TeachersDTO> basePage(TeachersDTO teachersDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param teachersDTO
    * @return
    */
    List<TeachersDTO> findList(TeachersDTO teachersDTO);

}
