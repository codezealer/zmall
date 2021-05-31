package com.codezealer.zmall.inventory.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author codezealer
 * @since 2021-05-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class InventoryOfflineStockUpdateMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 库存更新消息id
     */
    private String messageId;

    /**
     * 库存更新操作类型
     */
    private Integer operation;

    /**
     * 参数，json格式
     */
    private String parameter;

    /**
     * 参数类型
     */
    private String parameterClazz;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 修改时间
     */
    private LocalDateTime gmtModified;


}
