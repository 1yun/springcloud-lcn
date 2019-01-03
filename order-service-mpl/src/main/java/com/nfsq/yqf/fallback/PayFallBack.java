package com.nfsq.yqf.fallback;

import com.nfsq.yqf.common.YQFResult;
import com.nfsq.yqf.feign.PayFeign;
import org.springframework.stereotype.Component;

/**
 * Created by qfyu
 * Date:2019/1/3
 * Time:11:30
 **/
@Component
public class PayFallBack implements PayFeign {
    @Override
    public YQFResult pay(Integer id) {
        YQFResult result = new YQFResult();
        result.setSuccess(false);
        result.setMessage("当前请求人数过多，请稍后再试");
        return result;
    }
}
