package com.nfsq.yqf.bean;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by qfyu
 * Date:2019/1/2
 * Time:14:58
 **/
@Setter
@Getter
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;

    /**
     * 订单号
     */
    private String vbeln;


    /**
     * 订单状态
     */
    private int status;

    /**
     * 创建时间
     */
    private Date createData;

    /**
     * 修改时间
     */
    private Date modifyDate;

    /**
     * 修改人
     */
    private  String modifyBy;


}
