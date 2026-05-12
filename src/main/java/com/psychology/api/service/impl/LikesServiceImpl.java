package com.psychology.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.psychology.api.dao.LikesDao;
import com.psychology.api.dto.LikeDTO;
import com.psychology.api.service.LikesService;
import org.springframework.stereotype.Service;

/**
* @description: 管理员管理业务层实现类
* @author: psychology
* @create: 2023.09.22 10:41:10
*/
@Service(value = "likeService")
public class LikesServiceImpl extends ServiceImpl<LikesDao, LikeDTO> implements LikesService {



}
