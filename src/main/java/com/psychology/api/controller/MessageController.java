package com.psychology.api.controller;

import com.psychology.api.common.BaseController;
import com.psychology.api.common.ReturnMsg;
import com.psychology.api.dto.MessageDTO;
import com.psychology.api.service.MessageService;
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
* @description: 聊天对外接口层
* @author: wuming
* @create: 2024.02.22 10:30:14
*/
@RestController
@RequestMapping("/message")
public class MessageController extends BaseController<MessageService, MessageDTO> {


    @Override
    @Resource(name = "messageService")
    protected void setBaseService(MessageService messageService) {
        this.baseService = messageService;
    }

    /**
    * 默认分页查询
    * @param messageDTO
    * @return
    */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody MessageDTO messageDTO) {
        return ReturnMsg.ok(baseService.basePage(messageDTO));
    }

    /**
    * 根据XML中的sql语句进行查询
    * @param messageDTO
    * @return
    */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody MessageDTO messageDTO) {
        return ReturnMsg.ok(baseService.findList(messageDTO));
    }

    @Override
    protected void beforeSave(MessageDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }

}

