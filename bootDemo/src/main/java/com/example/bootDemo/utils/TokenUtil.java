package com.example.bootDemo.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * 描述: token工具类
 *
 * @author hanchong@mail.haoyisheng.com
 * @create 2020-01-20 9:01
 */
public class TokenUtil {

    /**
     *  生成一个根据密码生成的 大写TOKEN
     * @param pwd 用户密码
     * @return token
     */
    public static String getToken(String pwd) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        return (uuid + pwd).toUpperCase();
    }


    /**
     * 检查session中是否存在该token
     * @param token 请求携带token
     * @param request
     * @return true or false
     */
    public boolean checkToken(String token, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String sessionToken = (String) session.getAttribute("token");
        if (StringUtils.isNotBlank(sessionToken)) {
            return sessionToken.equals(token);
        }
        return false;
    }

}