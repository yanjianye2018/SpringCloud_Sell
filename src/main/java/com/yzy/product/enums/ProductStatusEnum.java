package com.yzy.product.enums;

import lombok.Getter;

/**
    商品上下架状态,
 * @Description
 */
@Getter//get方法,
public enum ProductStatusEnum {
    UP(0, "在架"),
    DOWN(1, "下架"),
    ;
    private Integer code;
    private String message;

    //枚举构造不用public
    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
