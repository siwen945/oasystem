package com.lingjie.oasystem.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LingJieAnZhuangVO {

    private String id;

    /**
     * 创建时间
     **/
    private String createTime;

    /**
     * 更新时间
     **/
    private String updateTime;


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
