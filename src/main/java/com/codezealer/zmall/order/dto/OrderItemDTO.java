package com.codezealer.zmall.order.dto;

import lombok.Data;

import java.util.Date;

/**
 * 订单条目DTO类
 */
@Data
public class OrderItemDTO {

	/**
	 * id
	 */
	private Long id;
	/**
	 * 订单id
	 */
	private Long orderInfoId;
	/**
	 * 商品id
	 */
	private Long goodsId;
	/**
	 * 商品sku id
	 */
	private Long goodsSkuId;
	/**
	 * 商品sku编号
	 */
	private String goodsSkuCode;
	/**
	 * 商品名称
	 */
	private String goodsName;
	/**
	 * 商品sku的销售属性
	 */
	private String saleProperties;
	/**
	 * 商品毛重
	 */
	private Double goodsGrossWeight;
	/**
	 * 商品sku的购买数量
	 */
	private Long purchaseQuantity;
	/**
	 * 商品sku的购买价格
	 */
	private Double purchasePrice;
	/**
	 * 商品sku使用的促销活动id
	 */
	private Long promotionActivityId;
	/**
	 * 商品长度
	 */
	private Double goodsLength;
	/**
	 * 商品宽度
	 */
	private Double goodsWidth;
	/**
	 * 商品高度
	 */
	private Double goodsHeight;
	/**
	 * 订单条目的创建时间
	 */
	private Date gmtCreate;
	/**
	 * 订单条目的修改时间
	 */
	private Date gmtModified;

	
	@Override
	public String toString() {
		return "OrderItemDTO [id=" + id + ", orderInfoId=" + orderInfoId + ", goodsId=" + goodsId + ", goodsSkuId="
				+ goodsSkuId + ", goodsSkuCode=" + goodsSkuCode + ", goodsName=" + goodsName + ", saleProperties="
				+ saleProperties + ", goodsGrossWeight=" + goodsGrossWeight + ", purchaseQuantity=" + purchaseQuantity
				+ ", purchasePrice=" + purchasePrice + ", promotionActivityId=" + promotionActivityId + ", goodsLength="
				+ goodsLength + ", goodsWidth=" + goodsWidth + ", goodsHeight=" + goodsHeight + ", gmtCreate="
				+ gmtCreate + ", gmtModified=" + gmtModified + "]";
	}
	
}
