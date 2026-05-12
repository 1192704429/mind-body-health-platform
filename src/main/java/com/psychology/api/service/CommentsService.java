package com.psychology.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.psychology.api.dto.CommentsDTO;
import java.util.List;
/**
* @description: 贴吧评论表业务层接口
* @author: wuming
* @create: 2024.02.22 10:30:14
*/
public interface CommentsService extends IService<CommentsDTO> {

    /**
    * 默认分页方法
    * @param commentsDTO
    * @return
    */
    Page<CommentsDTO> basePage(CommentsDTO commentsDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param commentsDTO
    * @return
    */
    List<CommentsDTO> findList(CommentsDTO commentsDTO);

}
