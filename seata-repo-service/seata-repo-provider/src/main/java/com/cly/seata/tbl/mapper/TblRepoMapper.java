package com.cly.seata.tbl.mapper;

import com.cly.seata.module.tbl.entity.TblRepo;
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
public interface TblRepoMapper extends BaseMapper<TblRepo> {
    /**
     *
     * @param productCode
     * @param count
     * @return
     */
    int decreaseRepo(@Param("productCode") String productCode, @Param("count") Integer count);
}
