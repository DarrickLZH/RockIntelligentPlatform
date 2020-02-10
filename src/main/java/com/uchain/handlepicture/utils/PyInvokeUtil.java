package com.uchain.handlepicture.utils;

import com.uchain.handlepicture.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @Author: LZH
 * @Date: 2019/12/5 下午5:16
 * @Description:
 */
@Slf4j
public class PyInvokeUtil {

    public static ResultVO pyInvoke(String[] arguments) throws Exception {
        Process process = Runtime.getRuntime().exec(arguments);
        /**
         * GBK是防止Python输出乱码
         */
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK"));
            String line = null;

            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            //java代码中的process.waitFor()返回值为0表示我们调用python脚本成功，
            //返回值为1表示调用python脚本失败，这和我们通常意义上见到的0与1定义正好相反
            int re = process.waitFor();
            if (re == 1) {
                log.info("调用脚本失败");
                return ResultVoUtil.error("调用失败");
            } else {
                log.info("调用脚本成功");
                return ResultVoUtil.success("调用成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultVoUtil.success();
    }
}
