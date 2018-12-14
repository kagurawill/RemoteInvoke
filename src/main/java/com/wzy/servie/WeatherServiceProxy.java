package com.wzy.servie;

import com.wzy.entity.Weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * 运用到了动态代理
 *
 */
public class WeatherServiceProxy implements InvocationHandler {

    //目标对象
    private Object target = null;

    /**
     * 定义获取代理对象
     *
     * @param target
     * @return
     */
    public Object getProxy(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //获取城市代码
        String cityCode = (String) args[0];
        Weather wea = new Weather();
        //远程调用的地址
        String remote_url = "http://www.weather.com.cn/data/sk/" + cityCode + ".html";
        try {
            //使用URL表示地址
            URL url = new URL(remote_url);
            //获取url的连接对象
            URLConnection urlconn = url.openConnection();
            //转为HttpURLConnection
            HttpURLConnection http_conn = (HttpURLConnection) urlconn;
            //设置请求的方式
            http_conn.setRequestMethod("GET");
            //连接远程地址
            http_conn.connect();
            //判断连接的结果
            if (http_conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream in = http_conn.getInputStream();
                BufferedReader bin = new BufferedReader(new InputStreamReader(in));
                String line = bin.readLine();
                if (line != null) {
                    Object[] newargs = new Object[]{line};
                    //调用目标方法
                    wea = (Weather) method.invoke(target, newargs);//这里会调用target即weatherserviceIpl的queryWeather方法
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return wea;
    }
}
