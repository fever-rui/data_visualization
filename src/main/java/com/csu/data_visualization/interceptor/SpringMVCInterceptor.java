package com.csu.data_visualization.interceptor;

import com.csu.data_visualization.util.getHost;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by ZhangRui on 2017/3/30.
 */
public class SpringMVCInterceptor implements HandlerInterceptor {

    private static final Logger logger=Logger.getLogger(SpringMVCInterceptor.class);

    /**
     * preHandle方法是进行处理器拦截用,该方法将在Controller处理之前进行调用
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        logger.info("ip:"+ getHost.getRemoteHost(request) +" preHandle函数,拦截器拦截 ");

        HttpSession session=request.getSession();
        String loginUrl = "login";
        String registerUrl="register";
        String indexUrl="index";
        String urlNow=request.getServletPath();
        if(urlNow.contains(loginUrl)||urlNow.contains(registerUrl)||urlNow.contains(indexUrl)){
            logger.info("url:"+urlNow+"  登录注册界面不拦截");
            return true;
        }else if(session.getAttribute("userAccount")==null) {
            logger.info("url:"+urlNow+"  拦截并跳转至登录界面");
            request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request,response);
            return false;
        }else {
            return true;
        }

    }

    /**
     * 在当前这个Interceptor的preHandle方法返回值为true的时候才会执行
     */
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub

    }

    /**
     * 当前对应的Interceptor的preHandle方法的返回值为true时才会执行。该方法将在整个请求完成之后，也就是DispatcherServlet渲染了视图执行，
     * 这个方法的主要作用是用于清理资源的，这个方法也只能在当前这个Interceptor的preHandle方法的返回值为true时才会执行。
     */
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // TODO Auto-generated method stub

    }

}
