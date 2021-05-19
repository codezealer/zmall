package com.codezealer.zmall.comment.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 评论聚合汇总表
 * </p>
 *
 * @author codezealer
 * @since 2021-05-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("comment_aggregate")
public class CommentAggregate implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品ID
     */
    private Long goodsId;

    /**
     * 评论总数量
     */
    private Long totalCommentCount;

    /**
     * 好评数量
     */
    private Long goodCommentCount;

    /**
     * 好评率
     */
    private BigDecimal goodCommentRate;

    /**
     * 晒图评论数量
     */
    private Long showPicturesCommentCount;

    /**
     * 中评数量
     */
    private Long mediumCommentCount;

    /**
     * 差评数量
     */
    private Long badCommentCount;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    private LocalDateTime gmtModified;


}
