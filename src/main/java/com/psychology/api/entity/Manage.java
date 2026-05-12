package com.psychology.api.entity;

import com.psychology.api.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
* @description: 管理员管理实体类
* @author: wuming
* @create: 2023.04.15 16:26:32
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Manage extends BaseEntity {

    /**
    * 管理员编号
    */
    private Long id;
    /**
    * 用户名
    */
    private String userName;
    /**
    * 密码
    */
    private String passWord;
    /**
    * 图片
    */
    private String photoImg;
    /**
    * 名称
    */
    private String name;


}
