package cn.sk.config;

import cn.sk.listener.SkHttpSessionListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.EventListener;

/**
 * @Deseription
 * @Author zhoucp
 * @Date 2021/3/4 16:08
 */
//@Configuration
public class SkSessionConfig {
    @Bean
    public ServletListenerRegistrationBean<EventListener> servletListenerRegistrationBean() {
        ServletListenerRegistrationBean<EventListener> srb = new ServletListenerRegistrationBean<>();
        //防止Spring内存溢出监听器
//        srb.setListener(new IntrospectorCleanupListener());
        //request监听器 主要需要配置这个监听器
//        srb.setListener(new RequestContextListener());
        srb.setListener(new SkHttpSessionListener());
        return srb;
    }

}
