package com.cly.seata.tbl.mapper;

import com.cly.seata.module.tbl.entity.TblOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cly
 * @since 2021-03-24
 */
public interface TblOrderMapper extends BaseMapper<TblOrder> {
    /**
     * 创建订单
     * @param order
     */
    void createOrder(TblOrder order);
}
