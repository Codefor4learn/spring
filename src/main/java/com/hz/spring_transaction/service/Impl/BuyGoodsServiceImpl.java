package com.hz.spring_transaction.service.Impl;

import com.hz.spring_transaction.dao.GoodsDao;
import com.hz.spring_transaction.dao.SaleDao;
import com.hz.spring_transaction.domain.Goods;
import com.hz.spring_transaction.domain.Sale;
import com.hz.spring_transaction.exception.NotEnoughException;
import com.hz.spring_transaction.service.BuyGoodsService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class BuyGoodsServiceImpl implements BuyGoodsService {

    private SaleDao saleDao;

    private GoodsDao goodsDao;

    public void setSaleDao(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    @Override
    /*@Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            readOnly = false,
            rollbackFor = {
                    NullPointerException.class
            },
            noRollbackFor = {
                    NotEnoughException.class
            }
    )*/
    public void buy(Integer goodsId, Integer nums) {

        System.out.println("buy方法的开始======");
        // 记录销售信息 添加销售记录
        Sale sale = new Sale();
        sale.setGid(goodsId);
        sale.setNums(nums);
        saleDao.insertSale(sale);

        // 更新库存
        Goods goods = goodsDao.selectGoods(goodsId);
        if(goods == null){
            // 商品不存在
            throw  new  NullPointerException("编号是:"+goodsId+"的商品不存在");
        }else if (goods.getAmount() < nums){
            throw new NotEnoughException("编号是:"+goodsId+"的商品库存不足");
        }

        // 修改库存
        Goods buyGoods = new Goods();
        buyGoods.setId(goodsId);
        buyGoods.setAmount(nums);
        goodsDao.updateGoods(buyGoods);

        System.out.println("buy方法完成======");

    }
}
