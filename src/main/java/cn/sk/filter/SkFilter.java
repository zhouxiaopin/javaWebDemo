package cn.sk.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Deseription
 * 过滤器是由Servlet容器创建
 * 过滤器是在请求进入容器后，但请求进入servlet之前进行预处理的
 * 过滤器获取不到IOC容器中的各个bean(需要手动获取applicationContext.getBean)
 * 过滤器的实现基于回调函数
 * Filter的执行由Servlet容器回调完成
 * Filter的生命周期由Servlet容器管理
 * 过滤器（Filter） ：可以拿到原始的http请求，但是拿不到你请求的控制器和请求控制器中的方法的信息。
 *
 * 过滤器应用场景
 * 1）过滤敏感词汇（防止sql注入）
 * 2）设置字符编码
 * 3）URL级别的权限访问控制
 * 4）压缩响应信息
 *
 * 过滤器和拦截器的区别
 * 过滤器和拦截器非常相似，但是它们有很大的区别
 * 最简单明了的区别就是过滤器可以修改request，而拦截器不能
 * 过滤器需要在servlet容器中实现，拦截器可以适用于javaEE，javaSE等各种环境
 * 拦截器可以调用IOC容器中的各种依赖，而过滤器不能
 * 过滤器只能在请求的前后使用，而拦截器可以详细到每个方法
 *
 * 优点：过滤链的好处是，执行过程中任何时候都可以打断，只要不执行chain.doFilter()
 *    就不会再执行后面的过滤器和请求的内容。而在实际使用时，就要特别注意过滤链的执行顺序问题
 * @Author zhoucp
 * @Date 2021/3/12 9:39
 */
//@Order(1) //@Order注解表示执行过滤顺序，值越小，越先执行
//@WebFilter(filterName = "filter1", urlPatterns = "/*")
public class SkFilter implements Filter {

    //执行以使用过滤器定义中的init-param元素初始化过滤器
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext servletContext = filterConfig.getServletContext();
//        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
//        context.getBean("filterRegistrationBean");
        System.out.println("SkFilter-----init");
    }

    //为满足“url-pattern”的所有HTTP传入请求执行
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("SkFilter-----doFilter");

        //执行了chain.doFilter(request, response)后面的过滤器才会执行
        chain.doFilter(request, response);//!!!!!!!!!!!!!!!!
    }

    //释放过滤器使用的资源
    @Override
    public void destroy() {
        System.out.println("SkFilter-----destroy");
    }
}
