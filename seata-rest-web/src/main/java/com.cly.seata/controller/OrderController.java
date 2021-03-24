package com.cly.seata.controller;

import com.cly.seata.common.api.vo.Result;
import com.cly.seata.module.tbl.dto.OrderRequest;
import com.cly.seata.service.IRestOrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 咕泡学院，只为更好的你
  咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/

@Slf4j
@RestController
public class OrderController {

    @Autowired
    IRestOrderService restOrderService;

    @PostMapping("/order")
    Result<Object> order(@RequestBody OrderRequest orderRequest) throws Exception {
        return restOrderService.handleBusiness(orderRequest);
    }
}
