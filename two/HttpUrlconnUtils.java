package com.bw.two;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shinelon on 2017/7/6.
 */

public class HttpUrlconnUtils {

    private static String s;

    public static List<Bean> HttpGet(final String path) {
        final List<Bean> list = new ArrayList<Bean>();
        new Thread() {
            @Override
            public void run() {
                try {
                    //建立地址对象
                    URL url = new URL(path);
                    //得到对象
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    //设置请求方式
                    conn.setRequestMethod("GET");
                    //设置响应时间
                    conn.setConnectTimeout(3000);
                    //读取超时时间
                    conn.setReadTimeout(3000);
                    //同步请求
                    if (conn.getResponseCode() == 200) {
                        InputStream is = conn.getInputStream();
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        byte[] buffer = new byte[1024];
                        int len = 0;
                        while ((len = is.read(buffer)) != -1) {
                            baos.write(buffer, 0, len);
                        }
                        s = baos.toString();
                        List<Bean.ApkBean> aList = new ArrayList<Bean.ApkBean>();
                        //得到第一层对象
                        JSONObject jsonObject = new JSONObject(s);
                        Bean bean = new Bean();
                        bean.setDataSize(jsonObject.getInt("dataSize"));
                        //得到第一层里包含的数组
                        JSONArray jsonArray = jsonObject.getJSONArray("apk");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            //解析数组里包含的第二层对象
                            JSONObject ob = jsonArray.getJSONObject(i);
                            Bean.ApkBean apk = new Bean.ApkBean();
                            apk.setId(ob.getString("id"));
                            apk.setName(ob.getString("name"));
                            apk.setIconUrl(ob.getString("iconUrl"));
                            apk.setDownloadUrl(ob.getString("downloadUrl"));
                            apk.setPackageName(ob.getString("packageName"));
                            apk.setVersionName(ob.getString("versionName"));
                            apk.setVersionCode(ob.getString("apkSize"));
                            apk.setDownloadTimes(ob.getString("downloadTimes"));
                            apk.setCategoryName(ob.getString("categoryName"));
                            apk.setFrom(ob.getString("from"));
                            apk.setMarkid(ob.getInt("markid"));
                            aList.add(apk);
                        }
                        bean.setApk(aList);
                        list.add(bean);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        return list;
    }
}
