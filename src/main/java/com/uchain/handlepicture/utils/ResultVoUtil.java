package com.uchain.handlepicture.utils;

import com.uchain.handlepicture.Enum.ResultEnum;
import com.uchain.handlepicture.vo.ResultVO;
import lombok.Data;

/**
 * @ClassName ResultVOUtil
 * @Author lzh
 * @Description
 **/
@Data
public class ResultVoUtil {

    /**
     * @param object
     * @return 有参成功结果
     * @author hobo
     */
    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }

    /***
     *
     * 无参成功结果
     *
     * @author hobo
     */
    public static ResultVO success() {
        return success(null);
    }

    /**
     * 返回错误结果
     *
     * @param resultEnum
     */
    public static ResultVO error(ResultEnum resultEnum) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(resultEnum.getCode());
        resultVO.setMsg(resultEnum.getMsg());
        return resultVO;
    }

    public static ResultVO error(String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(1);
        resultVO.setMsg(msg);
        return resultVO;
    }

}
