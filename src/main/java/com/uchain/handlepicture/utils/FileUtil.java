package com.uchain.handlepicture.utils;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: LZH
 * @Date: 2019/12/22 下午4:00
 * @Description:
 */
@Slf4j
public class FileUtil {

    public static boolean fileDownload(String fileName, String filePath, HttpServletResponse response, HttpServletRequest request) {
        log.info("文件路径为：" + filePath);
        File file1 = new File(filePath);
        if (file1.exists()) {
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
            // 设置文件名
            InputStream inStream = null;
            try {
                inStream = new FileInputStream(file1);
                // 循环取出流中的数据
                byte[] b = new byte[1024];
                int len;
                while ((len = inStream.read(b)) > 0) {
                    response.getOutputStream().write(b, 0, len);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            } finally {
                if (inStream != null) {
                    try {
                        inStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
