package com.psychology.api.controller;

import com.psychology.api.common.BaseController;
import com.psychology.api.common.ReturnMsg;
import com.psychology.api.dto.TeachersDTO;
import com.psychology.api.service.TeachersService;
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
* @description: 老师管理对外接口层
* @author: wuming
* @create: 2023.04.15 16:26:32
*/
@RestController
@RequestMapping("/teachers")
public class TeachersController extends BaseController<TeachersService, TeachersDTO> {


    @Override
    @Resource(name = "teachersService")
    protected void setBaseService(TeachersService teachersService) {
        this.baseService = teachersService;
    }

    /**
    * 默认分页查询
    * @param teachersDTO
    * @return
    */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody TeachersDTO teachersDTO) {
        return ReturnMsg.ok(baseService.basePage(teachersDTO));
    }

    /**
    * 根据XML中的sql语句进行查询
    * @param teachersDTO
    * @return
    */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody TeachersDTO teachersDTO) {
        return ReturnMsg.ok(baseService.findList(teachersDTO));
    }

    @Override
    protected void beforeSave(TeachersDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }

}

