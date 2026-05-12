package com.psychology.api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.psychology.api.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
/**
* @description: 试题管理实体类
* @author: wuming
* @create: 2023.04.15 16:26:32
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Questions extends BaseEntity {

    /**
    * 题目编号
    */
    private Long id;
    /**
    * 题目标题
    */
    private String title;
    /**
    * 选项A
    */
    private String optionA;
    /**
    * 选项B
    */
    private String optionB;
    /**
    * 选项C
    */
    private String optionC;
    /**
    * 选项D
    */
    private String optionD;
    /**
    * 答案A分数
    */
    private String gradeA;
    private String gradeB;
    private String gradeC;
    private String gradeD;

    /**
    * 老师编号
    */
    private Long teacherId;
    /**
    * 创建时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;


}
