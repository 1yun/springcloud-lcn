package com.nfsq.yqf.service;

import com.codingapi.tx.annotation.TxTransaction;
import com.nfsq.yqf.api.IOrderApi;
import com.nfsq.yqf.common.YQFResult;
import com.nfsq.yqf.feign.PayFeign;
import com.nfsq.yqf.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by qfyu
 * Date:2019/1/3
 * Time:11:28
 **/
@RestController
public class OrderService implements IOrderApi {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    PayFeign payFeign;

    /**
     * 添加@TxTransaction(isStart = true)注解后会在txmanager上注册一个事务分组id同时改写http的get和post请求，
     * 将分组id带过去，当pay服务调用成功后会做一个jdbc的假关闭，当整个方法执行完后txmanager会通知pay服务
     * 提交事务还是回滚事务，如果出现异常，本地事务走本地回滚。
     * 此次整合用的springboot版本是1.5.4的因为用2.0以上的版本会报错，原因还不清楚，且在启动这个项目之前要启动tx-manager
     * 配置tx-manager的注册中心以及redis的配置和redis一定要启动，
     * @param vbeln
     * @param temp
     * @return
     */
    @Override
    @RequestMapping("/submit")
    @TxTransaction(isStart = true)
    @Transactional
    public YQFResult submitOrder(String vbeln,Integer temp) {
        YQFResult result = new YQFResult();
        int i = orderMapper.updateOrderStatus(vbeln);
        Integer id = Integer.parseInt(vbeln);
        //通过feign客户端调用pay服务
        YQFResult response = payFeign.pay(id);
        int j = 1/temp;
        if(response.getSuccess() == true && i == 1){
            result.setSuccess(true);
            result.setMessage("同步完成");
        }else{
            result.setMessage("同步失败");
            result.setSuccess(false);
        }
        return result;
    }
}
