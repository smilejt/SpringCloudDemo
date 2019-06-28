/**
 * @FileName: LoginFilter.java
 * @author: LY
 * @Description:
 * @version V1.0
 */
package com.jt.abandon.spring.cloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @createDate: 2019/4/17 22:07
 * @author: LY
 * @Description: Zuul过滤器配置
 */
@Component
public class LoginFilter extends ZuulFilter {

    private static final Logger logger = LoggerFactory.getLogger(LoginFilter.class);

    /**
     * 配置拦截过滤类型，有四种不同生命周期的过滤器类型
     * 1. pre：路由之前
     * 2. routing：路由之时
     * 3. post：路由之后
     * 4. error：发送错误调用
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 配置过滤的顺序
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 配置是否需要过滤：true/需要，false/不需要
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体业务代码
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        logger.info("{} >>> {}", request.getMethod(), request.getRequestURL().toString());
        //模拟拦截未登录请求
//        String token = request.getParameter("token");
        String token = request.getHeader("token");
        if (token == null) {
            logger.warn("Token is empty");
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            try {
                HttpServletResponse response = context.getResponse();
                response.setContentType("text/html;charset=utf-8");
                context.getResponse().getWriter().write("非法请求");
            } catch (IOException e) {
                logger.error("[LoginFilter].[run]系统异常:{}",e.getMessage());
            }
        } else {
            logger.info("OK");
        }
        return null;
    }
}
