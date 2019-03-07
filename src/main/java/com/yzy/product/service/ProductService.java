package com.yzy.product.service;

import com.yzy.product.dataobject.ProductInfo;

import java.util.List;

/**
 * @Author yzy
 * @Date 2019/3/7 15:02
 * @Description
 */
public interface ProductService {
    /*
    查询所有在上架的商品列表
     */
    public abstract List<ProductInfo> findUpAll();
}
