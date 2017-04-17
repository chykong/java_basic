package com.critc;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created by 孔垂云 on 2017/4/8.
 * 这里面的加解密只是最简单的MD5和Base64
 */
public class CodecTest {

    public static void main(String[] args) {
        //MD5加密
        System.out.println("MD5加密：" + DigestUtils.md5Hex("abc"));

        //sha加密
        System.out.println("sha加密：" + DigestUtils.shaHex("def").toString());

        //加密
        String str = "abc"; // abc为要加密的字符串
        byte[] b = Base64.encodeBase64(str.getBytes(), true);
        System.out.println("base64加密：" + new String(b));

        //解密
        String str2 = "YWJj"; // YWJj为要解密的字符串
        byte[] b2 = Base64.decodeBase64(str2.getBytes());
        System.out.println("base64解密：" + new String(b2));
    }
}
