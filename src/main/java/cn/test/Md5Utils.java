package cn.test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Kuexun on 2018/7/16.
 */
public class Md5Utils {
    public static String toMd5(String origin){
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] digest = messageDigest.digest(origin.getBytes());
            return toHex(digest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("md5加密失败");
        }
    }

    private static String toHex(byte[] digest) {
        if(digest == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i < digest.length; i++)
        {
            //1 byte = 8 bit
            //16 = 4 bit
            //1 byte = 2 个hex
            int high = (digest[i]>>4) & 0x0f;
            int low = digest[i] & 0x0f;
            //将int转成相应16进制的值 11-->B
            stringBuilder.append(Character.forDigit(high,16)).append(Character.forDigit(low,16));
        }
        return stringBuilder.toString();
    }
}
