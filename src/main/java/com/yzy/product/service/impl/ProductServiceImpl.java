package com.yzy.product.service.impl;

import com.yzy.product.dataobject.ProductInfo;
import com.yzy.product.enums.ProductStatusEnum;
import com.yzy.product.repository.ProductInfoRepository;
import com.yzy.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author yzy
 * @Date 2019/3/7 15:04
 * @Description
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findUpAll() {
        //查询在架商品,
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }
}
