package com.psychology.api.entity;

import com.psychology.api.common.BaseEntity;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
* @description: 试卷管理实体类
* @author: wuming
* @create: 2023.04.15 16:26:32
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TestPaper extends BaseEntity {

    /**
    * 试卷编号
    */
    private Long id;
    /**
    * 所属老师
    */
    private Long teaId;
    /**
    * 试卷标题
    */
    private String title;
    /**
    * 封面图片
    */
    private String img;
    /**
    * 创建时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    /**
    * 总分
    */
    private String totalGrade;
    /**
    * 试卷简介
    */
    private String info;


}
