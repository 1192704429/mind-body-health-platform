package com.psychology.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.psychology.api.dto.TestQuestionsDTO;
import java.util.List;
/**
* @description: 试卷题目业务层接口
* @author: wuming
* @create: 2023.04.15 16:26:32
*/
public interface TestQuestionsService extends IService<TestQuestionsDTO> {

    /**
    * 默认分页方法
    * @param testQuestionsDTO
    * @return
    */
    Page<TestQuestionsDTO> basePage(TestQuestionsDTO testQuestionsDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param testQuestionsDTO
    * @return
    */
    List<TestQuestionsDTO> findList(TestQuestionsDTO testQuestionsDTO);

}
