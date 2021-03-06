package com.smart.framework.util;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.UUID;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;

/**
 * 字符串编码解码工具类
 */
public class CodecUtil {

    private static final Logger logger = Logger.getLogger(CodecUtil.class);

    // 将字符串 UTF-8 编码
    public static String encodeForUTF8(String str) {
        String target;
        try {
            target = URLEncoder.encode(str, "UTF-8");
        } catch (Exception e) {
            logger.error("编码出错！", e);
            throw new RuntimeException( e);
        }
        return target;
    }

    // 将字符串 UTF-8 解码
    public static String decodeForUTF8(String str) {
        String target;
        try {
            target = URLDecoder.decode(str, "UTF-8");
        } catch (Exception e) {
            logger.error("解码出错！", e);
            throw new RuntimeException(e);
        }
        return target;
    }

    // 将字符串 Base64 编码
    public static String encodeForBase64(String str) {
        return Base64.encodeBase64String(str.getBytes());
    }

    // 将字符串 Base64 解码
    public static String decodeForBase64(String str) {
        return new String(Base64.decodeBase64(str.getBytes()));
    }

    // 将字符串 MD5 加密
    public static String encryptForMD5(String str) {
        return DigestUtils.md5Hex(str);
    }

    // 将字符串 SHA 加密
    public static String encryptForSHA(String str) {
        return DigestUtils.sha1Hex(str);
    }

    // 创建随机数
    public static String createRandomNumber(int count) {
        return RandomStringUtils.randomNumeric(count);
    }

    // 获取UUID（32位）
    public static String createUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
