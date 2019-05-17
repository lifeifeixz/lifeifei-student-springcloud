package com.lifeifei.springcloud.starter.filter;


import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
@Order(2)
@Component
public class CustomFilter2 implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("第二个过滤器");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
