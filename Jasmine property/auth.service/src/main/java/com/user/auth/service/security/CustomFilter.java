package com.user.auth.service.security;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;

public class CustomFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // Custom logic before passing the request along the chain
        System.out.println("Custom Filter executed!");
        chain.doFilter(request, response);
        // Custom logic after processing the response
    }
}
