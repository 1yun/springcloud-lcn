package com.nfsq.yqf.api;

import com.nfsq.yqf.common.YQFResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by qfyu
 * Date:2018/12/5
 * Time:9:32
 **/
public interface IPayService {
    @RequestMapping(value = "/pay",method = RequestMethod.GET)
    YQFResult pay(@RequestParam("id") Integer id);
}
