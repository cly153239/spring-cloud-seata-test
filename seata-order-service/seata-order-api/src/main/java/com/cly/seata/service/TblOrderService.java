package com.cly.seata.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.cly.seata.common.api.vo.Result;
import com.cly.seata.module.tbl.dto.OrderDto;
import com.cly.seata.module.tbl.entity.TblOrder;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cly
 * @since 2021-03-24
 */
public interface TblOrderService extends IService<TblOrder> {
    /**
     * 创建订单
     * @param orderDto
     * @return
     */
    Result<Object> createOrder(OrderDto orderDto);
}
