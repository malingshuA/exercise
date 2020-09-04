package com.exercise.exercise.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 如果想diy一些定制化的功能，只要写这个组件，然后将它交给Springboot，springboot就会帮我们自动装配。
//扩展 SpringMVC
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 让"/"与"index" 等效
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");

    }

    //自定义组件
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    //拦截器
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("").excludePathPatterns("/index.html","/","/user/login","/css/**","/js/**","/img/**");
//    }

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
