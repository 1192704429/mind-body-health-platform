package com.psychology.api.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.psychology.api.entity. Records;
import lombok.Data;
import lombok.ToString;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
* @description: 建档信息数据传输层
* @author: wuming
* @create: 2023.04.15 16:26:32
*/
@Data
@ToString
@TableName("records")
public class RecordsDTO extends Records {

    /**
    * 试卷标题
    */
    @TableField(exist = false)
    private String title;
    /**
    * 封面图片
    */
    @TableField(exist = false)
    private String img;
    /**
    * 总分
    */
    @TableField(exist = false)
    private String totalGrade;
    /**
    * 学生姓名
    */
    @TableField(exist = false)
    private String stuName;
    /**
    * 照片
    */
    @TableField(exist = false)
    private String stuImg;

}
