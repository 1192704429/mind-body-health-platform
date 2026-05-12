package com.psychology.api.entity;

import com.psychology.api.common.BaseEntity;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
* @description: 试卷规则管理实体类
* @author: wuming
* @create: 2023.04.15 16:26:32
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TestRules extends BaseEntity {

    /**
    * 规则编号
    */
    private Long id;
    /**
    * 所属试卷
    */
    private Long testId;
    /**
    * 最低分数
    */
    private Integer minGrade;
    /**
    * 最高分数
    */
    private Integer maxGrade;
    /**
    * 对应结果
    */
    private String info;
    /**
    * 创建时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    /**
    * 老师编号
    */
    private Long teaId;


}
