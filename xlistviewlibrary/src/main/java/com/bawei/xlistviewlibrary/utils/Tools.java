package com.bawei.xlistviewlibrary.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * date:2016/7/2
 * author:易宸锋(dell)
 * function:把字节流转换为字符串
 */
public class Tools {

    public static String getTextFromStream(InputStream is){

        byte[] b = new byte[1024];
        int len;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            while((len = is.read(b)) != -1){
                bos.write(b, 0, len);
            }
            //把流中的数据转换成字节数组的形式，然后用字节数组构造一个字符串
            byte[] bt = bos.toByteArray();
            bos.close();
            return new String(bt);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
