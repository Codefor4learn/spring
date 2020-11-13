package com.hz.spring_transaction.dao;

import com.hz.spring_transaction.domain.Goods;

public interface GoodsDao {

    // 更新库存
    // goods表示本次用户购买的商品id 数量
    int updateGoods(Goods goods);

    // 查询商品信息
    Goods selectGoods(Integer id);
}
