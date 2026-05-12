package com.psychology.api.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.psychology.api.entity.TestQuestions;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
* @description: 试卷题目数据传输层
* @author: wuming
* @create: 2023.04.15 16:26:32
*/
@Data
@ToString
@TableName("test_questions")
public class TestQuestionsDTO extends TestQuestions {

    /**
    * 题目标题
    */
    @TableField(exist = false)
    private String title;
    /**
    * 分数
    */
    @TableField(exist = false)
    private Long qId;
    /**
    * 试卷标题
    */
    @TableField(exist = false)
    private String testTitle;
    /**
    * 创建时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(exist = false)
    private Date createTime;

}
