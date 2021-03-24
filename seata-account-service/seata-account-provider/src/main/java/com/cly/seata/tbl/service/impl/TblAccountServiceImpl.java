package com.cly.seata.tbl.service.impl;

import com.cly.seata.common.api.vo.Result;
import com.cly.seata.common.constant.ResCode;
import com.cly.seata.module.tbl.dto.AccountDto;
import com.cly.seata.module.tbl.entity.TblAccount;
import com.cly.seata.service.TblAccountService;
import com.cly.seata.tbl.mapper.TblAccountMapper;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cly
 * @since 2021-03-24
 */
@Service
public class TblAccountServiceImpl extends ServiceImpl<TblAccountMapper, TblAccount> implements TblAccountService {
    @Autowired
    private TblAccountMapper accountMapper;
    @Override
    public Result<Object> decreaseAccount(AccountDto accountDto) {
        Result response=new Result();
        try{
            int rs=accountMapper.decreaseAccount(accountDto.getUserId(),accountDto.getBalance().doubleValue());
            if(rs>0){
                response.setMessage(ResCode.SUCCESS.getMessage());
                response.setCode(ResCode.SUCCESS.getCode());
                return response;
            }
            response.setMessage(ResCode.FAILED.getMessage());
            response.setCode(ResCode.FAILED.getCode());
        }catch (Exception e){
            log.error("decreaseAccount Occur Exception:"+e);
            response.setCode(ResCode.SYSTEM_EXCEPTION.getCode());
            response.setMessage(ResCode.SYSTEM_EXCEPTION.getMessage()+"-"+e.getMessage());
        }
        return response;
    }
}
