package com.psychology.api.controller;

import com.psychology.api.common.BaseController;
import com.psychology.api.common.ReturnMsg;
import com.psychology.api.dto.ManageDTO;
import com.psychology.api.service.ManageService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import com.psychology.api.common.BaseSelectEntity;
import cn.hutool.core.collection.CollectionUtil;
/**
* @description: 管理员管理对外接口层
* @author: wuming
* @create: 2023.04.15 16:26:32
*/
@RestController
@RequestMapping("/manage")
public class ManageController extends BaseController<ManageService, ManageDTO> {


    @Override
    @Resource(name = "manageService")
    protected void setBaseService(ManageService manageService) {
        this.baseService = manageService;
    }

    /**
    * 默认分页查询
    * @param manageDTO
    * @return
    */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody ManageDTO manageDTO) {
        return ReturnMsg.ok(baseService.basePage(manageDTO));
    }

    /**
    * 根据XML中的sql语句进行查询
    * @param manageDTO
    * @return
    */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody ManageDTO manageDTO) {
        return ReturnMsg.ok(baseService.findList(manageDTO));
    }


}

