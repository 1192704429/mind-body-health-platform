package com.psychology.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.psychology.api.dto.TestPaperDTO;
import java.util.List;
/**
* @description: 试卷管理业务层接口
* @author: wuming
* @create: 2023.04.15 16:26:32
*/
public interface TestPaperService extends IService<TestPaperDTO> {

    /**
    * 默认分页方法
    * @param testPaperDTO
    * @return
    */
    Page<TestPaperDTO> basePage(TestPaperDTO testPaperDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param testPaperDTO
    * @return
    */
    List<TestPaperDTO> findList(TestPaperDTO testPaperDTO);

}
