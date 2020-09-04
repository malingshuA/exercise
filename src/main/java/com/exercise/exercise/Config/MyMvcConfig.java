package com.exercise.exercise.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 如果想diy一些定制化的功能，只要写这个组件，然后将它交给Springboot，springboot就会帮我们自动装配。
//扩展 SpringMVC
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    
   // public interface ViewResolver  实现了视图解析器接口的类，我们就可以把他们看作视图解析器

    //请求会经过dispatchservlet类
//    @Bean
//    public ViewResolver myViewResolver(){
//        return new MyViewResolver();
//    }


    // 自定义的视图解析器
//    public static class MyViewResolver implements ViewResolver{
//
//        @Override
//        public View resolveViewName(String viewName, Locale locale) throws Exception {
//            return null;
//        }
//    }
}
