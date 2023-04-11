package com.lingjie.oasystem.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Data
@EqualsAndHashCode()
@ToString(callSuper = true)
@TableName("tb_lingjie_anzhaung")
public class LingJieAnZhuang extends BaseEntity {

    private String contractNum;

    private Integer approvalStatus;

    private String productName;

    private String xinghao;

    private Integer taishu;

    private BigDecimal contractMoney;

    private String kpjfk;

    private BigDecimal backMoney;

    private String cgzfmx;

    private BigDecimal zhifushuetj;

    private String lldbh;

    private String beizhu;

    private String opinion;

    private String opinionone;

    private String opiniontwo;

    private String remark;

    private Date jctime;

    private Date wgtime;

    private BigDecimal banzujiesuan;

    private String sgbanzu;


}
