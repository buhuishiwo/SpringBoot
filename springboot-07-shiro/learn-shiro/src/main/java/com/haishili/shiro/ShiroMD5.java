package com.haishili.shiro;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.lang.util.ByteSource;

/**
 * @author haishili
 * @date 2025/4/27
 */
public class ShiroMD5 {
    public static void main(String[] args) {
        String password = "md5";
        SimpleHash simpleHash = new SimpleHash("md5", password, "md5",1024);
        System.out.println("simpleHash.toHex() = " + simpleHash.toHex());
    }
}
