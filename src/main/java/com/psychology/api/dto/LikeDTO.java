package com.psychology.api.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.psychology.api.entity.Likes;
import lombok.Data;
import lombok.ToString;

/**
* @description: 树木申请管理数据传输层
* @author: psychology
* @create: 2023.09.22 10:41:10
*/
@Data
@ToString
@TableName("likes")
public class LikeDTO extends Likes {



}
