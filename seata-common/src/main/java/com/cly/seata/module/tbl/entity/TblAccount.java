package com.cly.seata.module.tbl.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
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
  public class TblAccount extends Model<TblAccount> {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

    private String userId;

    private Integer balance;


    @Override
    protected Serializable pkVal() {
          return this.id;
      }

}
