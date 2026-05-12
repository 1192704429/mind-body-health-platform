package com.psychology.api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.psychology.api.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
/**
* @description: 建档信息实体类
* @author: wuming
* @create: 2023.04.15 16:26:32
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Records extends BaseEntity {

    /**
    * 档案编号
    */
    private Long id;
    /**
    * 学生编号
    */
    private Long stuId;
    /**
    * 试卷编号
    */
    private Long testId;
    /**
    * 教师编号
    */
    private Long teaId;
    /**
    * 考试分数
    */
    private String grade;

    private String info;
    /**
    * 创建时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;


}
