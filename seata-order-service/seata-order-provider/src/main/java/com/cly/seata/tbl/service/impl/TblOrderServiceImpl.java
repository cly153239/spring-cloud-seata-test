package com.cly.seata.tbl.service.impl;

import com.cly.seata.common.api.vo.Result;
import com.cly.seata.common.constant.ResCode;
import com.cly.seata.module.tbl.dto.AccountDto;
import com.cly.seata.module.tbl.dto.OrderDto;
import com.cly.seata.module.tbl.entity.TblOrder;
import com.cly.seata.service.TblAccountService;
import com.cly.seata.service.TblOrderService;
import com.cly.seata.tbl.mapper.TblOrderMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cly
 * @since 2021-03-24
 */
@Service
@Slf4j
public class TblOrderServiceImpl extends ServiceImpl<TblOrderMapper, TblOrder> implements TblOrderService {
    @Autowired
    TblOrderMapper orderMapper;
    @Reference
    TblAccountService accountService;
    @Override
    public Result<Object> createOrder(OrderDto orderDto) {
        log.info("全局事务ID："+ RootContext.getXID());
        Result<Object> response=new Result<>();
        try {
            //账户扣款
            AccountDto accountDto = new AccountDto();
            accountDto.setUserId(orderDto.getUserId());
            accountDto.setBalance(orderDto.getOrderAmount());
            Result<Object> accountRes = accountService.decreaseAccount(accountDto);
            //创建订单
            TblOrder order=new TblOrder();
            order.setOrderNo(UUID.randomUUID().toString());
            order.setAmount(orderDto.getOrderAmount());
            order.setCount(orderDto.getOrderCount());
            orderMapper.createOrder(order);
            //判断扣款状态(判断可以前置）
            if(accountRes.getCode()!= ResCode.SUCCESS.getCode()){
                response.setMessage(ResCode.FAILED.getMessage());
                response.setCode(ResCode.FAILED.getCode());
                return response;
            }
            response.setMessage(ResCode.SUCCESS.getMessage());
            response.setCode(ResCode.SUCCESS.getCode());
        }catch (Exception e){
            log.error("createOrder Occur Exception:"+e);
            response.setCode(ResCode.SYSTEM_EXCEPTION.getCode());
            response.setMessage(ResCode.SYSTEM_EXCEPTION.getMessage()+"-"+e.getMessage());
        }
        return response;
    }
}
