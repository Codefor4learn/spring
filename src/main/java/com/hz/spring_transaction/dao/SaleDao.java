package com.hz.spring_transaction.dao;

import com.hz.spring_transaction.domain.Sale;

public interface SaleDao {

    //增加销售记录
    int insertSale(Sale sale);
}
