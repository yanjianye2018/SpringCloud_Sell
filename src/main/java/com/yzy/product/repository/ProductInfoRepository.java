package com.yzy.product.repository;

import com.yzy.product.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author yzy
 * @Date 2019/3/7 14:40
 * @Description
 */
//泛型第二个参数为主键类型

public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {
    //查询所有在架的商品,
   public abstract List<ProductInfo> findByProductStatus(Integer productStatus);
}
