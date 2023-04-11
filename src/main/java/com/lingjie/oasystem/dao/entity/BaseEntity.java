package com.lingjie.oasystem.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class BaseEntity {

    /**
     * ID
     **/
    @TableId(type = IdType.AUTO)
    private String id;

    /**
     * 创建时间
     **/
    private Date createTime;


    /**
     * 更新时间
     **/
    private Date updateTime;

}
