package com.nfsq.yqf.feign;

import com.nfsq.yqf.api.IPayService;
import com.nfsq.yqf.fallback.PayFallBack;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by qfyu
 * Date:2019/1/3
 * Time:11:29
 **/
@FeignClient(value = "pay",fallback = PayFallBack.class)
public interface PayFeign extends IPayService {
}
