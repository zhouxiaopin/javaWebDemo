package cn.sk.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @Deseription
 * HttpSession：对应session会话，实现接口HttpSessionListener。在会话起始时创建，
 * 一端关闭会话后销毁。可用作获取在线用户数量
 * @Author zhoucp
 * @Date 2021/3/4 15:32
 */
@WebListener
public class SkHttpSessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("HttpSessionListener 创建会话"+se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("HttpSessionListener 销毁会话"+se.getSession().getId());
    }
}
