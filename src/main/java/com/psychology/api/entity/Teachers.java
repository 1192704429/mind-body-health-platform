package com.psychology.api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.psychology.api.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
/**
* @description: 老师管理实体类
* @author: wuming
* @create: 2023.04.15 16:26:32
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Teachers extends BaseEntity {

    /**
    * 教师编号
    */
    private Long id;
    /**
    * 账号
    */
    private String username;
    /**
    * 密码
    */
    private String password;
    /**
    * 姓名
    */
    private String teaName;
    private String mail;
    /**
    * 年龄
    */
    private Integer teaAge;
    /**
    * 性别
    */
    private Integer teaSex;
    /**
    * 简介
    */
    private String teaInfo;
    /**
    * 联系方式
    */
    private String teaTel;
    /**
    * 头像
    */
    private String teaImg;
    /**
    * 创建时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;


}
