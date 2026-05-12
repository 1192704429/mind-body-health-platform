package com.psychology.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.psychology.api.dto.QuestionsDTO;
import java.util.List;
/**
* @description: 试题管理业务层接口
* @author: wuming
* @create: 2023.04.15 16:26:32
*/
public interface QuestionsService extends IService<QuestionsDTO> {

    /**
    * 默认分页方法
    * @param questionsDTO
    * @return
    */
    Page<QuestionsDTO> basePage(QuestionsDTO questionsDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param questionsDTO
    * @return
    */
    List<QuestionsDTO> findList(QuestionsDTO questionsDTO);

}
