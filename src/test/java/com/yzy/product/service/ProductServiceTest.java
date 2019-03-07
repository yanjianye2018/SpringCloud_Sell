package com.yzy.product.service;

import com.yzy.product.ProductApplicationTests;
import com.yzy.product.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author yzy
 * @Date 2019/3/7 15:11
 * @Description
 */
@Component//继承测试主类就不用注解了,
public class ProductServiceTest extends ProductApplicationTests {
    @Autowired
    private ProductService productService;

    @Test
    public void findUpAll() {
        List<ProductInfo> list = productService.findUpAll();
        Assert.assertTrue(list.size() > 0);

    }
}