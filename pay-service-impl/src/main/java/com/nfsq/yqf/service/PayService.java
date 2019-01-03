package com.nfsq.yqf.service;

import com.codingapi.tx.annotation.TxTransaction;
import com.nfsq.yqf.api.IPayService;
import com.nfsq.yqf.common.YQFResult;
import com.nfsq.yqf.mapper.PayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by qfyu
 * Date:2019/1/3
 * Time:11:15
 **/
@RestController
public class PayService implements IPayService {

    @Autowired
    PayMapper payMapper;

    /**
     * 添加@TxTransaction注解的作用是说明此方法走的是分布式事务，txmanager在方法执行完毕后会通知该服务该提交事务还是回滚事务
     * 在类上实现ITxTransactional也是可以的
     * @param id
     * @return
     */
    @Override
    @TxTransaction
    @Transactional
    public YQFResult pay(Integer id) {
        YQFResult result = new YQFResult();
        int i = payMapper.updatePayInfo(id);
        if(i == 1){
            result.setSuccess(true);
            result.setMessage("修改支付信息成功");
        }else{
            result.setMessage("修改支付信息失败");
            result.setSuccess(false);
        }
        return result;
    }
}
