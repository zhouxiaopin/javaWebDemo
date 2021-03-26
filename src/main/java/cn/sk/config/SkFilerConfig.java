package cn.sk.config;

import cn.sk.filter.SkFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Deseription 
 * @Author zhoucp
 * @Date 2021/3/12 9:44
 */
@Configuration
public class SkFilerConfig {
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean bean = new FilterRegistrationBean(new SkFilter());
        bean.addUrlPatterns("/*");
        bean.addInitParameter("exclusions","*.ioc,*.js");
        return bean;
    }

}
