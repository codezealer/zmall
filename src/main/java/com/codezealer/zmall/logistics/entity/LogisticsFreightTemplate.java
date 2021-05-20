package com.codezealer.zmall.logistics.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 物流中心的运费模板表
 * </p>
 *
 * @author codezealer
 * @since 2021-05-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class LogisticsFreightTemplate implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 运费模板名称
     */
    private String freightTemplateName;

    /**
     * 运费模板类型，1：固定运费，2：满X元包邮，3：自定义规则
     */
    private Integer freightTemplateType;

    /**
     * 运费模板的规则
     */
    private String freightTemplateRule;

    /**
     * 运费模板的说明备注
     */
    private String freightTemplateComment;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    private LocalDateTime gmtModified;


}
