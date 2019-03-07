package com.yzy.product.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author yzy
 * @Date 2019/3/7 15:21
 * @Description
 */
@Data
public class ProductVO {
    //类目名字
    //返回给前端的必须是name @JsonProperty可以指定name值,
    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;



}
