package com.psychology.api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.psychology.api.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
* @description: 管理员管理实体类
* @author: psychology
* @create: 2023.09.22 10:41:10
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Likes extends BaseEntity {

    /**
    * 管理员编号
    */
    private Long id;
    /**
    * 昵称
    */
    private Long userId;
    /**
    * 账号
    */
    private Long commonId;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;


}
