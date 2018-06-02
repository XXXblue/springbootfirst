package com.xjy.springbootfirst.Filter;


import com.xjy.springbootfirst.aspect.HttpAspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author: XBlue
 * @Date: Create in 2018/6/215:10
 * @Description:
 * @Modified By:
 */
public class LogFilter implements Filter {
    private final static Logger logger = LoggerFactory.getLogger(LogFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("----------请求到来-----------");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
