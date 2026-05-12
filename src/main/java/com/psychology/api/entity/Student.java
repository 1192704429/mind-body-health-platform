package com.psychology.api.entity;

import com.psychology.api.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
* @description: 学生表实体类
* @author: wuming
* @create: 2023.04.15 16:26:32
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student extends BaseEntity {

    /**
    * 学生编号
    */
    private Long id;
    /**
    * 学生姓名
    */
    private String stuName;
    private String username;
    /**
    * 年龄
    */
    private Integer stuAge;
    /**
    * 性别
    */
    private Integer stuSex;
    /**
    * 联系方式
    */
    private String stuPhone;
    /**
    * 家庭住址
    */
    private String stuAddress;
    /**
    * 所属班级
    */
    private String stuClassNum;
    /**
    * 照片
    */
    private String stuImg;
    /**
    * 登录密码
    */
    private String password;


}
