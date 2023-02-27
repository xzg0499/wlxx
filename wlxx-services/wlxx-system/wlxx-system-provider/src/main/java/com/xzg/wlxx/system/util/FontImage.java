package com.xzg.wlxx.system.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.charset.Charset;


/**
 * 合成图片+文字
 *
 * @author xzgan
 * @project wlxx
 * @package com.xzg.wlxx.system
 * @date 2022/12/23 22:52
 */


// 参考自https://blog.csdn.net/hometing218/article/details/88419874
// 参考自https://www.cnblogs.com/remember-forget/p/8134823.html
public class FontImage {
    public static void main(String[] args) throws Exception {
        createImage("请A1003到3号窗口, 请A1002到2号窗口, 请A1001到1号窗口, 测试测试, 测试2, 测试3\n请A1002到3号窗口\n请A1001到3号窗口"
                , new Font("宋体", Font.PLAIN, 28), new File("d:\\a.jpg"), new File("D:\\背景图片.jpg"));
    }

    public static void createImage(String str, Font font, File outFile, File bgImageFile) throws Exception {
        // 读取背景图
        Image bgImage = ImageIO.read(bgImageFile);
        Integer width = bgImage.getWidth(null);
        Integer height = bgImage.getHeight(null);
        // 创建图片
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
        Graphics g = image.getGraphics();
        g.setClip(0, 0, width, height);
        g.drawImage(bgImage, 0, 0, width, height, null);
        g.setColor(Color.black);
        g.setFont(font);
        MyDrawText drawText = new MyDrawText();
        BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(str.getBytes()), Charset.forName("utf8")));
        String line;
        int locY = g.getFontMetrics().getHeight();
        while (null != (line = br.readLine())) {
            locY = drawText.drawStringWithFontStyleLineFeed(g, line, 0, locY, font, width - g.getFontMetrics().charWidth(' '));
            locY += g.getFontMetrics().getHeight();
        }

        g.dispose();
        // 输出png图片
        ImageIO.write(image, "png", outFile);
    }
}

// 参考自https://www.cnblogs.com/kgdjgd/p/10248977.html
class MyDrawText {
    public int drawStringWithFontStyleLineFeed(Graphics g, String strContent, int locX, int locY, Font font, int rowWidth) {
        //获取字符串 字符的总宽度
        int strWidth = getStringLength(g, strContent);
        System.out.println("每行字符宽度:" + rowWidth);
        //获取字符高度
        int strHeight = getStringHeight(g);
        //字符串总个数
        System.out.println("字符串总个数:" + strContent.length());
        if (strWidth > rowWidth) {
            int rowstrnum = getRowStrNum(strContent.length(), rowWidth, strWidth);
            int rows = getRows(strWidth, rowWidth);
            String temp = "";
            for (int i = 0; i < rows; i++) {
                //获取各行的String
                if (i == rows - 1) {
                    //最后一行
                    temp = strContent.substring(i * rowstrnum);
                } else {
                    temp = strContent.substring(i * rowstrnum, i * rowstrnum + rowstrnum);
                }
                if (i > 0) {
                    //第一行不需要增加字符高度，以后的每一行在换行的时候都需要增加字符高度
                    locY = locY + strHeight;
                }
                g.drawString(temp, locX, locY);
            }
        } else {
            //直接绘制
            g.drawString(strContent, locX, locY);
        }

        return locY;
    }

    private int getRows(int strWidth, int rowWidth) {
        int rows = 0;
        if (strWidth % rowWidth > 0) {
            rows = strWidth / rowWidth + 1;
        } else {
            rows = strWidth / rowWidth;
        }
        System.out.println("行数:" + rows);
        return rows;
    }

    private int getStringHeight(Graphics g) {
        int height = g.getFontMetrics().getHeight();
        System.out.println("字符高度:" + height);
        return height;
    }

    private int getRowStrNum(int strnum, int rowWidth, int strWidth) {
        int rowstrnum = 0;
        rowstrnum = (rowWidth * strnum) / strWidth;
        System.out.println("每行的字符数:" + rowstrnum);
        return rowstrnum;
    }

    private int getStringLength(Graphics g, String str) {
        int strWidth = g.getFontMetrics().stringWidth(str);
        System.out.println("字符总宽度:" + strWidth);
        return strWidth;
    }
}

