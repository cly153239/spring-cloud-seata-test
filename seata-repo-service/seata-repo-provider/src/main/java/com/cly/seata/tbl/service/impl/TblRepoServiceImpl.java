package com.cly.seata.tbl.service.impl;

import com.cly.seata.common.api.vo.Result;
import com.cly.seata.common.constant.ResCode;
import com.cly.seata.module.tbl.dto.ProductDto;
import com.cly.seata.module.tbl.entity.TblRepo;
import com.cly.seata.service.TblRepoService;
import com.cly.seata.tbl.mapper.TblRepoMapper;
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
public class TblRepoServiceImpl extends ServiceImpl<TblRepoMapper, TblRepo> implements TblRepoService {
    @Autowired
    private TblRepoMapper repoMapper;
    @Override
    public Result<Object> decreaseRepo(ProductDto productDto) {
        Result<Object> response=new Result<>();
        try {
            int repo = repoMapper.decreaseRepo(productDto.getProductCode(), productDto.getCount());
            if(repo>0){
                response.setMessage(ResCode.SUCCESS.getMessage());
                response.setCode(ResCode.SUCCESS.getCode());
                return response;
            }
            response.setMessage(ResCode.FAILED.getMessage());
            response.setCode(ResCode.FAILED.getCode());
        }catch (Exception e){
            log.error("decreaseRepo Occur Exception:"+e);
            response.setCode(ResCode.SYSTEM_EXCEPTION.getCode());
            response.setMessage(ResCode.SYSTEM_EXCEPTION.getMessage()+"-"+e.getMessage());
        }
        return response;
    }
}
