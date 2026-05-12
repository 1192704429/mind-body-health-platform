package com.psychology.api.controller;

import com.psychology.api.common.BaseController;
import com.psychology.api.common.ReturnMsg;
import com.psychology.api.dto.MessageInfoDTO;
import com.psychology.api.service.MessageInfoService;
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
* @description: 聊天详情对外接口层
* @author: wuming
* @create: 2024.02.22 10:30:14
*/
@RestController
@RequestMapping("/messageInfo")
public class MessageInfoController extends BaseController<MessageInfoService, MessageInfoDTO> {


    @Override
    @Resource(name = "messageInfoService")
    protected void setBaseService(MessageInfoService messageInfoService) {
        this.baseService = messageInfoService;
    }

    /**
    * 默认分页查询
    * @param messageInfoDTO
    * @return
    */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody MessageInfoDTO messageInfoDTO) {
        return ReturnMsg.ok(baseService.basePage(messageInfoDTO));
    }

    /**
    * 根据XML中的sql语句进行查询
    * @param messageInfoDTO
    * @return
    */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody MessageInfoDTO messageInfoDTO) {
        return ReturnMsg.ok(baseService.findList(messageInfoDTO));
    }

    @Override
    protected void beforeSave(MessageInfoDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }

}

