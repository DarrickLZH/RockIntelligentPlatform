package com.uchain.handlepicture.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : LZH
 * @Date: 2019/9/29 下午2:46
 * @Description:
 */
@Slf4j
@WebFilter(urlPatterns = "/*")
@Component
public class CorsFilter extends OncePerRequestFilter {

    private static final String OPTIONS = "OPTIONS";

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        if (httpServletRequest.getMethod().equals("OPTIONS")) {
            log.info("浏览器的请求预处理");
            httpServletResponse.setHeader("Access-Control-Allow-Origin", httpServletRequest.getHeader("origin"));
            httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS,DELETE");
            httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
            httpServletResponse.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept,WG-Token");
            httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
            return;
        }
        log.info("预请求处理！");
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
