package com.psychology.api.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.psychology.api.entity.TestRules;
import lombok.Data;
import lombok.ToString;

/**
 * @description: 试卷规则管理数据传输层
 * @author: wuming
 * @create: 2023.04.15 16:26:32
 */
@Data
@ToString
@TableName("test_rules")
public class TestRulesDTO extends TestRules {

    @TableField(exist = false)
    private String title;


}
