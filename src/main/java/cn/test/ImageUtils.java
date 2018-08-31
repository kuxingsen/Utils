package cn.test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Kuexun on 2018/7/25.
 */
public class ImageUtils {

    /**
     * 功能：获取图片像素
     * * @param srcFilePath 图片路径
     */
    public static String getPixel(String srcFilePath){
        File file = new File(srcFilePath);
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int width = bi.getWidth(); // 像素
        int height = bi.getHeight(); // 像素
        return width+"*"+height;
    }
    /**
     * @param srcFilePath  源图片路径
     * @param desPath  修改大小后图片路径
     * @param newWidth 图片的修改比例，目标宽度
     */
    public static void resizeImage(String srcFilePath, String desPath,int newWidth) throws IOException {
        File srcFile = new File(srcFilePath);
        desPath = desPath.concat("\\"+srcFile.getName());

        BufferedImage bi = null;
        try {
            bi = ImageIO.read(srcFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        float width = bi.getWidth(); // 像素
        float height = bi.getHeight(); // 像素
        float scale=width/newWidth;
        int newHeight = (int)(height/scale);
        BufferedImage buffImg = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);

        //https://blog.csdn.net/itdragons/article/details/70325763 修改图片png格式透明背景
        Graphics2D g2d = buffImg.createGraphics();
        buffImg = g2d.getDeviceConfiguration().createCompatibleImage(newWidth, newHeight,
                Transparency.TRANSLUCENT);
        g2d.dispose();
        g2d = buffImg.createGraphics();
        @SuppressWarnings("static-access")
        Image from = bi.getScaledInstance(newWidth, newHeight, bi.SCALE_AREA_AVERAGING);
        g2d.drawImage(from, 0, 0, null);
        g2d.dispose();
        ImageIO.write(buffImg, "png", new File(desPath));
    }

    /**
     *
     * @param srcFilePath 原图片路径
     * @param desPath  转换大小后图片路径
     * @param newWidth   转换后图片宽度
     * @param newHeight  转换后图片高度
     */
    public static void resizeImage(String srcFilePath, String desPath,
                                   int newWidth, int newHeight) throws IOException {
        File srcFile = new File(srcFilePath);
        desPath = desPath.concat("\\"+srcFile.getName());

        BufferedImage bi = null;
        try {
            bi = ImageIO.read(srcFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        BufferedImage buffImg = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);

        //https://blog.csdn.net/itdragons/article/details/70325763 修改图片png格式透明背景
        Graphics2D g2d = buffImg.createGraphics();
        buffImg = g2d.getDeviceConfiguration().createCompatibleImage(newWidth, newHeight,
                Transparency.TRANSLUCENT);
        g2d.dispose();
        g2d = buffImg.createGraphics();
        @SuppressWarnings("static-access")
        Image from = bi.getScaledInstance(newWidth, newHeight, bi.SCALE_AREA_AVERAGING);
        g2d.drawImage(from, 0, 0, null);
        g2d.dispose();
        ImageIO.write(buffImg, "png", new File(desPath));
    }
    /**
     * @param path  源图片文件夹路径
     * @param modPath  修改大小后图片文件夹路径
     * @param scaleSize 图片的修改比例，目标宽度
     */
    public static void getFiles(String path,String modPath,int scaleSize) throws IOException {
        ArrayList<String> files = new ArrayList<String>();
        File file = new File(path);
        File[] tempList = file.listFiles();
        //循环读取目录下图片
        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) {
                System.out.println("文件：" + tempList[i].getName()+"-"+tempList[i].getAbsolutePath().replaceAll("\\\\","/"));
                String[] imagePath=tempList[i].getAbsolutePath().replaceAll("\\\\","/").split("/");
                String imageNumber=null;
                ImageUtils.resizeImage(tempList[i].getAbsolutePath().replaceAll("\\\\","/"),modPath,scaleSize);
                files.add(tempList[i].toString());
            }
            if (tempList[i].isDirectory()) {
//                  System.out.println("文件夹：" + tempList[i]);
            }
        }
        System.out.println(path+"下文件数量："+files.size());
    }
}
