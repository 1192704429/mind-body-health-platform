package com.psychology.api.controller;

import com.psychology.api.common.BaseController;
import com.psychology.api.common.ReturnMsg;
import com.psychology.api.dto.QuestionsDTO;
import com.psychology.api.service.QuestionsService;
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
* @description: 试题管理对外接口层
* @author: wuming
* @create: 2023.04.15 16:26:32
*/
@RestController
@RequestMapping("/questions")
public class QuestionsController extends BaseController<QuestionsService, QuestionsDTO> {


    @Override
    @Resource(name = "questionsService")
    protected void setBaseService(QuestionsService questionsService) {
        this.baseService = questionsService;
    }

    /**
    * 默认分页查询
    * @param questionsDTO
    * @return
    */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody QuestionsDTO questionsDTO) {
        return ReturnMsg.ok(baseService.basePage(questionsDTO));
    }

    /**
    * 根据XML中的sql语句进行查询
    * @param questionsDTO
    * @return
    */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody QuestionsDTO questionsDTO) {
        return ReturnMsg.ok(baseService.findList(questionsDTO));
    }

    @Override
    protected void beforeSave(QuestionsDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }

}

