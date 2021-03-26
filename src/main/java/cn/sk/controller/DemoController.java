package cn.sk.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Deseription
 * @Author zhoucp
 * @Date 2021/3/4 15:48
 */
@RestController
public class DemoController {
    @GetMapping("/test")
    public String test(HttpServletRequest request){
        request.getSession();//调用这个HttpSessionListener才可以监听到，这个方法是创建session
        return "123";
    }
}
