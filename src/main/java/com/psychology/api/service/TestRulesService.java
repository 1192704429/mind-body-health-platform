package com.psychology.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.psychology.api.dto.TestRulesDTO;
import java.util.List;
/**
* @description: 试卷规则管理业务层接口
* @author: wuming
* @create: 2023.04.15 16:26:32
*/
public interface TestRulesService extends IService<TestRulesDTO> {

    /**
    * 默认分页方法
    * @param testRulesDTO
    * @return
    */
    Page<TestRulesDTO> basePage(TestRulesDTO testRulesDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param testRulesDTO
    * @return
    */
    List<TestRulesDTO> findList(TestRulesDTO testRulesDTO);

}
