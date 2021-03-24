package com.cly.seata.module.tbl.entity;

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
  public class TblRepo extends Model<TblRepo> {

    private static final long serialVersionUID=1L;

      private Integer id;

    private String productCode;

    private Integer count;

    private String name;


    @Override
    protected Serializable pkVal() {
          return this.id;
      }

}
