package com.nfsq.yqf.bean;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by qfyu
 * Date:2019/1/2
 * Time:15:19
 **/
@Setter
@Getter
public class PayInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private int status;

    private Date createDate;

    private Date modifyDate;

    private String modifyBy;
}
