package com.cly.seata.service;


import com.cly.seata.common.api.vo.Result;
import com.cly.seata.module.tbl.dto.OrderRequest;

public interface IRestOrderService {

   Result<Object> handleBusiness(OrderRequest orderRequest) throws Exception;
}
