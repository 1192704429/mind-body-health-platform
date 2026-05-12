package com.psychology.api.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.psychology.api.dao.CommentsDao;
import com.psychology.api.dto.CommentsDTO;
import com.psychology.api.service.CommentsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 贴吧评论表业务层实现类
* @author: wuming
* @create: 2024.02.22 10:30:14
*/
@Service("commentsService")
public class CommentsServiceImpl extends ServiceImpl<CommentsDao, CommentsDTO> implements CommentsService {

    @Override
    public Page<CommentsDTO> basePage(CommentsDTO commentsDTO) {
        if (null != commentsDTO.getCurrent() && null != commentsDTO.getPageSize())
            commentsDTO.setCurrent((commentsDTO.getCurrent() - 1) * commentsDTO.getPageSize());
        List<CommentsDTO> list = this.baseMapper.findList(commentsDTO);
        int count = this.baseMapper.findPageCount(commentsDTO);
        Page<CommentsDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<CommentsDTO> findList(CommentsDTO commentsDTO) {
        return this.baseMapper.findList(commentsDTO);
    }

}
