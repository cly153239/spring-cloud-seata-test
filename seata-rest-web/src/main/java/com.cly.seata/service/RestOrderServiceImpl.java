package com.cly.seata.service;

import com.cly.seata.common.api.vo.Result;
import com.cly.seata.module.tbl.dto.OrderDto;
import com.cly.seata.module.tbl.dto.OrderRequest;
import com.cly.seata.module.tbl.dto.ProductDto;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @Author: heshouyou
 * @Description  Dubbo业务发起方逻辑
 * @Date Created in 2019/1/14 18:36
 */
@Slf4j
@Service
public class RestOrderServiceImpl implements IRestOrderService {
    @Reference
    TblOrderService orderService;
    @Reference
    TblRepoService repoService;

    @Override
    @GlobalTransactional(timeoutMills = 300000, name = "sample-rest-web")
    public Result<Object> handleBusiness(OrderRequest orderRequest) throws Exception {
        log.info("开始全局事务:xid="+ RootContext.getXID());
        log.info("begin order: "+orderRequest);
        //1. 扣减库存
        ProductDto productDto=new ProductDto();
        productDto.setProductCode(orderRequest.getProductCode());
        productDto.setCount(orderRequest.getCount());
        Result<Object> repoRes=repoService.decreaseRepo(productDto);
        //2. 创建订单
        OrderDto orderDto=new OrderDto();
        orderDto.setUserId(orderRequest.getUserId());
        orderDto.setOrderAmount(orderRequest.getAmount());
        orderDto.setOrderCount(orderRequest.getCount());
        orderDto.setProductCode(orderRequest.getProductCode());
        Result orderRes=orderService.createOrder(orderDto);
        if(orderRequest.getProductCode().equals("GP20200202002")){
            throw new Exception("系统异常");
        }
        Result response=new Result();
        response.setResult(orderRes.getResult());
        return response;
    }
}
