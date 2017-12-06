package com.qhit.sbms.goods.service;

import com.qhit.sbms.goods.bean.Goods;

public interface GoodsService {
	/**
	 * @param GoodsName
	 * @return
	 * 根据商品名称去查询商品信息
	 */
	public Goods getGoodsInfoByName(String goodsName);
	/**
	 * @param num
	 * @param goodsId
	 * @return
	 * 更新库存
	 */
	public int updateStore(int num, int goodsId);
}
