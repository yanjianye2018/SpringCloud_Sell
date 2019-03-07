package com.yzy.product.service;

import com.yzy.product.dataobject.ProductCategory;

import java.util.List;

/**
    商品类目列表接口
 * @Description
 */
public interface CategoryService {
    public abstract List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
