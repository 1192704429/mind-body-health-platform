package com.psychology.api.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.psychology.api.common.BaseController;
import com.psychology.api.common.ReturnMsg;
import com.psychology.api.dto.CommentsDTO;
import com.psychology.api.dto.LikeDTO;
import com.psychology.api.service.CommentsService;
import com.psychology.api.service.LikesService;
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
import java.util.stream.Collectors;

/**
* @description: 贴吧评论表对外接口层
* @author: wuming
* @create: 2024.02.22 10:30:14
*/
@RestController
@RequestMapping("/comments")
public class CommentsController extends BaseController<CommentsService, CommentsDTO> {

    @Autowired
    private LikesService likesService;

    @Override
    @Resource(name = "commentsService")
    protected void setBaseService(CommentsService commentsService) {
        this.baseService = commentsService;
    }

    /**
    * 默认分页查询
    * @param commentsDTO
    * @return
    */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody CommentsDTO commentsDTO) {
        return ReturnMsg.ok(baseService.basePage(commentsDTO));
    }

    /**
    * 根据XML中的sql语句进行查询
    * @param commentsDTO
    * @return
    */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody CommentsDTO commentsDTO) {
        return ReturnMsg.ok(baseService.findList(commentsDTO));
    }

    @Override
    protected void beforeSave(CommentsDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }

    @PostMapping(value = "/allComments")
    public ReturnMsg allComments(@RequestBody CommentsDTO commentsDTO) {
        commentsDTO.setIsOrder("true");
        List<CommentsDTO> baseServiceList = baseService.findList(commentsDTO);
        LambdaQueryWrapper<LikeDTO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(LikeDTO::getUserId, commentsDTO.getUserId());
        List<LikeDTO> likeDTOS = likesService.list(queryWrapper);
        List<Long> collected = likeDTOS.stream().map(LikeDTO::getCommonId).collect(Collectors.toList());
        if (CollectionUtil.isNotEmpty(baseServiceList)) {
            for (CommentsDTO dto : baseServiceList) {
                if (CollectionUtil.isNotEmpty(collected)) {
                    dto.setIsLike(collected.contains(dto.getId()));
                }
                CommentsDTO query = new CommentsDTO();
                query.setParentId(dto.getId());
                dto.setCommentsDTOS(this.baseService.findList(query));
                // 查询点赞量
                dto.setClickNum(getClick(dto.getId()));
            }
        }
        return ReturnMsg.ok(baseServiceList);
    }

    public Integer getClick(Long cid) {
        LambdaQueryWrapper<LikeDTO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(LikeDTO::getCommonId, cid);
        return likesService.count(queryWrapper);
    }
}

