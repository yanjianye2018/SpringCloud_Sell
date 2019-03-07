package com.yzy.product.utils;

import com.yzy.product.VO.ResultVO;

/**
 * @Author yzy
 * @Date 2019/3/7 16:30
 * @Description
 */
public class ResultVOUtils {
    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }
}
