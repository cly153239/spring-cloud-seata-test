package com.cly.seata.service;

import com.cly.seata.common.api.vo.Result;
import com.cly.seata.module.tbl.dto.AccountDto;
import com.cly.seata.module.tbl.entity.TblAccount;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cly
 * @since 2021-03-24
 */
public interface TblAccountService extends IService<TblAccount> {
    /**
     * 从账户扣款
     * @param accountDto
     * @return
     */
    Result<Object> decreaseAccount(AccountDto accountDto);
}
