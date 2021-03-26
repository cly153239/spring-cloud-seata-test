package com.cly.seata.module.tbl.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author cly
 * @since 2021-03-24
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
  public class TblOrder extends Model<TblOrder> {

    private static final long serialVersionUID=1L;
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private String orderNo;
    private String userId;
    private String productCode;
    private Integer count;
    private BigDecimal amount;

    @Override
    protected Serializable pkVal() {
          return this.id;
      }

}
