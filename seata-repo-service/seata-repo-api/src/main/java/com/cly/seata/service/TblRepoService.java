package com.cly.seata.service;

import com.cly.seata.common.api.vo.Result;
import com.cly.seata.module.tbl.dto.ProductDto;
import com.cly.seata.module.tbl.entity.TblRepo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cly
 * @since 2021-03-24
 */
public interface TblRepoService extends IService<TblRepo> {

    /**
     * 扣减库存
     */
    Result<Object> decreaseRepo(ProductDto productDto);
}
