package com.lezijie.admin.config;

import com.lezijie.admin.intercepter.EncodingInterceptor;
import com.lezijie.admin.intercepter.NoLoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
    @Bean
    public NoLoginInterceptor noLoginInterceptor(){
        return new NoLoginInterceptor();
    };
    @Bean
    public EncodingInterceptor encodingInterceptor(){
        return new EncodingInterceptor();
    };

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(noLoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/index","/login","/static/css/**",
                        "/static/js/**","/static/font/**",
                        "/static/images/**","/static/error/**",
                        "/static/lib/**");
        registry.addInterceptor(encodingInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/static/css/**",
                        "/static/js/**","/static/font/**",
                        "/static/images/**","/static/error/**",
                        "/static/lib/**");
    }
}
