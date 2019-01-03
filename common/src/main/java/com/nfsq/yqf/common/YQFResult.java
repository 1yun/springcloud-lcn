package com.nfsq.yqf.common;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by qfyu
 * Date:2019/1/3
 * Time:11:06
 **/
@Setter
@Getter
public class YQFResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private String message;
    private Boolean success;
    private T data;
}
