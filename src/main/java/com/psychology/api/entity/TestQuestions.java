package com.psychology.api.entity;

import com.psychology.api.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
* @description: 试卷题目实体类
* @author: wuming
* @create: 2023.04.15 16:26:32
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TestQuestions extends BaseEntity {

    /**
    * 主键ID
    */
    private Long id;
    /**
    * 所属试卷
    */
    private Long testId;
    /**
    * 题目编号
    */
    private Long questionId;
    /**
    * 老师编号
    */
    private Long teaId;


}
