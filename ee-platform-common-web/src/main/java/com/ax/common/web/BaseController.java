package com.ax.common.web;

import com.ax.common.security.JwtAuthUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by kyy on 2017/9/7.
 */
@Slf4j
public class BaseController {

    public JwtAuthUserDetails getSessionUser() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            JwtAuthUserDetails userDetails = (JwtAuthUserDetails) authentication.getPrincipal();
            return userDetails;
        } catch (Exception e) {
            log.debug(e.getMessage(), e);
        }
        return null;
    }
    
    /**
     * 获取客户端的IP地址
     *
     * @return
     */
    public String getIpAddress(HttpServletRequest request) {
        String ipAddress = null;
        ipAddress = request.getHeader("x-forwarded-for");
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
                // 根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    log.error(e.getMessage(), e);
                }
                ipAddress = inet.getHostAddress();
            }

        }

        // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ipAddress != null && ipAddress.length() > 15) {
            if (ipAddress.indexOf(",") > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
            }
        }
        return ipAddress;
    }

    /**
     * 获取refererUrl
     */
    public String getRefererUrl(HttpServletRequest request) {
        return request.getHeader("referer");
    }


    public void writeFile(HttpServletResponse response, File file) {
        try {
            writeFile(response, new FileInputStream(file), file.getName());
        } catch (FileNotFoundException e) {
            log.error(e.getMessage(), e);
        }
    }

    public void writeFile(HttpServletResponse response, InputStream inputStream, String fileName) {
        response.setContentType("application/octet-stream; charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
        try {
            ServletOutputStream outputStream = response.getOutputStream();
            byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                outputStream.write(b, 0, length);
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

}
