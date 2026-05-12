package com.psychology.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.psychology.api.dto.ManageDTO;
import java.util.List;
/**
* @description: 管理员管理业务层接口
* @author: wuming
* @create: 2023.04.15 16:26:32
*/
public interface ManageService extends IService<ManageDTO> {

    /**
    * 默认分页方法
    * @param manageDTO
    * @return
    */
    Page<ManageDTO> basePage(ManageDTO manageDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param manageDTO
    * @return
    */
    List<ManageDTO> findList(ManageDTO manageDTO);

}
