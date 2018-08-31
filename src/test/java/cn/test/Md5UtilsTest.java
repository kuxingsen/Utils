package cn.test;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Kuexun on 2018/7/16.
 */
public class Md5UtilsTest {
    @Test
    public void toMd5() throws Exception {
        System.out.println(Md5Utils.toMd5("aaa"));
    }

}