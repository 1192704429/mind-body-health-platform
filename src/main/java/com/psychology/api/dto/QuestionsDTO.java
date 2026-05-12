package com.psychology.api.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.psychology.api.entity. Questions;
import lombok.Data;
import lombok.ToString;

/**
* @description: 试题管理数据传输层
* @author: wuming
* @create: 2023.04.15 16:26:32
*/
@Data
@ToString
@TableName("questions")
public class QuestionsDTO extends Questions {


}
