package com.yzy.product.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Author yzy
 * @Date 2019/3/7 14:50
 * @Description
 */
@Data
@Entity
public class ProductCategory {
    @Id
    @GeneratedValue//自增主键
    private Integer categoryId;

    /** 类目名字. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;
}
