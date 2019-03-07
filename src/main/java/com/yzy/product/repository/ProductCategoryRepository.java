package com.yzy.product.repository;

import com.yzy.product.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author yzy
 * @Date 2019/3/7 14:54
 * @Description
 */
//泛型第二个参数为主键类型
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
    public abstract List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
