package com.cly.seata.tbl.mapper;

import com.cly.seata.module.tbl.entity.TblAccount;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cly
 * @since 2021-03-24
 */
public interface TblAccountMapper extends BaseMapper<TblAccount> {
    int decreaseAccount(@Param("userId") String userId, @Param("balance") Double balance);
}
