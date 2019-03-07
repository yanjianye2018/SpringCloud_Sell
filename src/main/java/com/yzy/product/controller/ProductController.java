package com.yzy.product.controller;

import com.yzy.product.VO.ProductInfoVO;
import com.yzy.product.VO.ProductVO;
import com.yzy.product.VO.ResultVO;
import com.yzy.product.dataobject.ProductCategory;
import com.yzy.product.dataobject.ProductInfo;
import com.yzy.product.service.CategoryService;
import com.yzy.product.service.ProductService;
import com.yzy.product.utils.ResultVOUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yzy
 * @Date 2019/3/6 16:23
 * @Description 商品;
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    /*
    1.查询所有在架的商品表,
    2,获取类目type列表
    3,查询类目,
    4,构造数据
     */
    @GetMapping("/list")
    public ResultVO<ProductVO> list() {
        //1.查询所有在架的商品表,
        List<ProductInfo> productInfoList = productService.findUpAll();

        //2,获取类目type列表
/*        List<Integer> categoryTypeList = productInfoList.stream().map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());*/
        //上面那句相当于这句
        List<Integer> categoryTypeList = new ArrayList<>();
       for(ProductInfo productInfo : productInfoList){
            Integer categoryType = productInfo.getCategoryType();
            categoryTypeList.add(categoryType);
        }

        //3从数据库查询类目
        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
        //4构造数据
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : categoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());
            //遍历商品的数据获取封装list
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                //2个类型相等才设置,
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    //第一个参数是原对象,第二个为要封装后的对象,
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            //将对象添加到list中
            productVOList.add(productVO);
        }


        return ResultVOUtils.success(productVOList);
    }
}
