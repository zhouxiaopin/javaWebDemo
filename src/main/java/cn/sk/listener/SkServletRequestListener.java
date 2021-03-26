package cn.sk.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * @Deseription
 * ServletRequest：对应request，实现接口ServletRequestListener。request对象是客户发送请求时创建的，
 * 用于封装请求数据，请求处理完毕后销毁。可用作封装用户信息
 * @Author zhoucp
 * @Date 2021/3/4 15:36
 */
@WebListener
public class SkServletRequestListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("ServletRequestListener 初始化请求");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("ServletRequestListener 请求销毁");
    }
}
