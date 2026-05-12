package com.psychology.api.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.psychology.api.common.BaseController;
import com.psychology.api.common.ReturnMsg;
import com.psychology.api.dto.LikeDTO;
import com.psychology.api.service.LikesService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description: 管理员管理对外接口层
 * @author: psychology
 * @create: 2023.09.22 10:41:10
 */
@RestController
@RequestMapping("/likes")
public class LikesController extends BaseController<LikesService, LikeDTO> {


    @Override
    @Resource(name = "likeService")
    protected void setBaseService(LikesService LikeService) {
        this.baseService = LikeService;
    }


    /**
     *
     * @return
     */
    @PostMapping(value = "/del/like")
    public ReturnMsg delLike(@RequestBody LikeDTO likeDTO) {
        LambdaQueryWrapper<LikeDTO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(LikeDTO::getUserId, likeDTO.getUserId()).eq(LikeDTO::getCommonId, likeDTO.getCommonId());
        this.baseService.remove(queryWrapper);
        return ReturnMsg.ok();
    }


}

