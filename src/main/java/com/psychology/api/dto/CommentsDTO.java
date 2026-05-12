package com.psychology.api.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.psychology.api.entity. Comments;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
* @description: 贴吧评论表数据传输层
* @author: wuming
* @create: 2024.02.22 10:30:14
*/
@Data
@ToString
@TableName("comments")
public class CommentsDTO extends Comments {

    /**
    * 学生姓名
    */
    @TableField(exist = false)
    private String stuName;


    /**
     * 头像
     */
    @TableField(exist = false)
    private String stuImg;

    /**
     * 用户姓名
     */
    @TableField(exist = false)
    private String nickNameTo;
    /**
     * 用户头像
     */
    @TableField(exist = false)
    private String headerImgTo;

    @TableField(exist = false)
    private List<CommentsDTO> commentsDTOS;

    @TableField(exist = false)
    private List<CommentsDTO> children;

    @TableField(exist = false)
    private String isOrder;

    @TableField(exist = false)
    private Long userId;

    @TableField(exist = false)
    private Integer clickNum;
    @TableField(exist = false)
    private Boolean isLike;
}
