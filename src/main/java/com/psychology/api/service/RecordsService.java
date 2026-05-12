package com.psychology.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.psychology.api.dto.RecordsDTO;
import java.util.List;
/**
* @description: 建档信息业务层接口
* @author: wuming
* @create: 2023.04.15 16:26:32
*/
public interface RecordsService extends IService<RecordsDTO> {

    /**
    * 默认分页方法
    * @param recordsDTO
    * @return
    */
    Page<RecordsDTO> basePage(RecordsDTO recordsDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param recordsDTO
    * @return
    */
    List<RecordsDTO> findList(RecordsDTO recordsDTO);

}
