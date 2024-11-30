package com.example.lms.util;


import jakarta.servlet.http.HttpServletRequest;

public class RequestUtils {
    public static String getUserAgent(HttpServletRequest request) {
        return request.getHeader("User-Agent");
    }

    public static String getClientIP(HttpServletRequest request) {
        String ip = request.getHeader("X-FORWARDED-FOR");

        if (ip == null || ip.isEmpty()) {
            ip = request.getHeader("Proxy-Client-IP");
        }

        if (ip == null || ip.isEmpty()) {
            ip = request.getHeader("WL-Proxy-Client-IP");  // 웹로직
        }

        if (ip == null || ip.isEmpty()) {
            ip = request.getRemoteAddr();
        }

        return ip;
    }
}
