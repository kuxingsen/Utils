package cn.test;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Kuexun on 2018/7/25.
 */
public class ImageUtilsTest {
    private String srcPath;
    private String desPath;
    private String srcFileName;
    @Before
    public void init()
    {
        srcPath = "D:\\imageTest";
        desPath = "D:\\imageTest\\modify";
        srcFileName = "1.jpg";
    }
    @Test
    public void getPixel() throws Exception {
        System.out.println(ImageUtils.getPixel(srcPath+"\\"+srcFileName));
    }

    @Test
    public void resizeImage() throws Exception {
        ImageUtils.resizeImage(srcPath+"\\"+srcFileName,desPath,32);
    }

    @Test
    public void resizeImage1() throws Exception {
        int weight = 132;
        int height = 132;
        ImageUtils.resizeImage(srcPath+"\\"+srcFileName,desPath,weight,height);
    }

    @Test
    public void getFiles() throws Exception {
        ImageUtils.getFiles(srcPath,desPath,32);
    }

}