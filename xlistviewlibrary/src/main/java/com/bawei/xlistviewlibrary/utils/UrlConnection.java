package com.bawei.xlistviewlibrary.utils;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * date:2017/7/27
 * author:易宸锋(dell)
 * function:网络请求的工具类(记得加网络权限)
 *
         String urlPath ="http://huixinguiyu.cn/Assets/js/data.js";
         Map<String,Object> map=new HashMap<>();
         map.put("channelId",0);
         map.put("startNum",0);
         String result = UrlConnection.postUrlConnect(urlPath,map);
 */

public class UrlConnection {

    //post请求
    public static String postUrlConnect(String urlPath, Map<String, Object> map) {
        StringBuffer sbRequest = new StringBuffer();
        if (map != null && map.size() > 0) {
            for (String key : map.keySet()) {
                sbRequest.append(key + "=" + map.get(key) + "&");
            }
        }
        String request = sbRequest.substring(0, sbRequest.length() - 1);
        System.out.println(request);
        try {
            URL url = new URL(urlPath);
            HttpURLConnection httpurl = (HttpURLConnection) url.openConnection();
            httpurl.setRequestMethod("POST");
            //设置连接主机超时
            httpurl.setConnectTimeout(30000);
            //设置从主机读取数据超时
            httpurl.setReadTimeout(30000);
            httpurl.setDoInput(true);
            httpurl.setDoOutput(true);
            //读取数据
            OutputStream os = httpurl.getOutputStream();
            os.write(request.getBytes());
            //刷新
            os.flush();
            //判断返回值是否正确
            if (httpurl.getResponseCode() == 200) {
                InputStream in = httpurl.getInputStream();
                StringBuffer sb = new StringBuffer();
                //创建字符数组
                byte[] buff = new byte[1024];
                int len = -1;
                while ((len = in.read(buff)) != -1) {
                    sb.append(new String(buff, 0, len, "utf-8"));
                }
                //关闭流
                in.close();
                os.close();
                httpurl.disconnect();
                return sb.toString();
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return urlPath;
    }

    //get请求
    public static String getUrlConnect(String urlPath) {
        try {
            //获取地址
            URL url = new URL(urlPath);
            //通过URL对象.openConnection,强转为(HttpURLConnection),的到HttpURLConnection对象
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();//http.https
            //实际就是对HttpURLConnection进行初始化设置,设置请求模式:setRequestMethod
            httpURLConnection.setRequestMethod("GET");
            //设置连接超时时间.setConnectTimeout,注意单位是毫秒.
            httpURLConnection.setConnectTimeout(8000);
            //设置读取的超时时间,setReadTimeout,注意单位是毫秒.
            httpURLConnection.setReadTimeout(8000);
            //获取http返回的状态码..getResponseCode();
            int responseCode = httpURLConnection.getResponseCode();//200
            System.out.println(responseCode);
            //判断返回值
            if (responseCode == 200) {
                //获取服务器的返回的流,getInputStream();
                InputStream in = httpURLConnection.getInputStream();

                StringBuffer sb = new StringBuffer();
                byte[] buff = new byte[1024];
                int len = -1;
                while ((len = in.read(buff)) != -1) {
                    sb.append(new String(buff, 0, len, "utf-8"));
                }
                in.close();
                httpURLConnection.disconnect();

                return sb.toString();
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
