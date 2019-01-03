package com.nfsq.yqf.api;

import com.nfsq.yqf.common.YQFResult;

/**
 * Created by qfyu
 * Date:2019/1/2
 * Time:15:05
 **/
public interface IOrderApi {
    YQFResult submitOrder(String vbeln, Integer temp);
}
