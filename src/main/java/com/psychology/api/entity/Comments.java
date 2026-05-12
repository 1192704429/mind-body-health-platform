package com.psychology.api.entity;

import com.psychology.api.common.BaseEntity;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
* @description: 贴吧评论表实体类
* @author: wuming
* @create: 2024.02.22 10:30:14
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Comments extends BaseEntity {

    /**
    * 贴吧编号
    */
    private Long id;
    /**
    * 评论学生编号
    */
    private Long fromStuId;
    /**
    * 评论内容
    */
    private String content;
    /**
    * 回复人编号
    */
    private Long toStuId;
    /**
    * 父级评论编号
    */
    private Long parentId;
    /**
    * 图片列表
    */
    private String imgList;
    /**
    * 评论时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    /**
    * 类型
    */
    private Integer type;


}
