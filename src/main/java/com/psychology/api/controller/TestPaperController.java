package com.psychology.api.controller;

import com.psychology.api.common.BaseController;
import com.psychology.api.common.ReturnMsg;
import com.psychology.api.dto.TestPaperDTO;
import com.psychology.api.service.TestPaperService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import com.psychology.api.common.BaseSelectEntity;
import cn.hutool.core.collection.CollectionUtil;
import java.util.Date;
/**
* @description: 试卷管理对外接口层
* @author: wuming
* @create: 2023.04.15 16:26:32
*/
@RestController
@RequestMapping("/testPaper")
public class TestPaperController extends BaseController<TestPaperService, TestPaperDTO> {


    @Override
    @Resource(name = "testPaperService")
    protected void setBaseService(TestPaperService testPaperService) {
        this.baseService = testPaperService;
    }

    /**
    * 默认分页查询
    * @param testPaperDTO
    * @return
    */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody TestPaperDTO testPaperDTO) {
        return ReturnMsg.ok(baseService.basePage(testPaperDTO));
    }

    /**
    * 根据XML中的sql语句进行查询
    * @param testPaperDTO
    * @return
    */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody TestPaperDTO testPaperDTO) {
        return ReturnMsg.ok(baseService.findList(testPaperDTO));
    }

    @Override
    protected void beforeSave(TestPaperDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }

}

