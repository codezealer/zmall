package com.codezealer.zmall.common.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class WebContextUtil {



    private static HttpServletRequest getContextHolder() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }

    public static String getContextPath() {
        return getContextHolder().getContextPath();
    }

    public static String getStaticFileDir() {
        return getContextHolder().getSession().getServletContext().getRealPath("static");
    }

    /**
     * 获取真实ip地址
     * @return
     */
    public static String getRealIp() {
        HttpServletRequest request = getContextHolder();
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
