package cn.sk.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @Deseription
 * 拦截顺序：ServletContextListener> Filter > Interception > AOP > 具体执行的方法 >
 *          AOP > @ControllerAdvice > Interception > Filter > ServletContextListener
 * ServletContext：对应application，实现接口ServletContextListener。在整个Web服务中只有一个，
 * 在Web服务关闭时销毁。可用于做数据缓存，例如结合redis，在Web服务创建时从数据库拉取数据到缓存服务器。
 * @Author zhoucp
 * @Date 2021/3/4 15:24
 */
@WebListener
public class SkServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ServletContextListener 初始化上下文");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContextListener 销毁");
    }
}
