package per.jxy.idempotentdemo.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import per.jxy.idempotentdemo.annotation.ApiIdempotent;
import per.jxy.idempotentdemo.exception.ServiceException;
import per.jxy.idempotentdemo.service.TokenService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class ApiIdempotentInterceptor implements HandlerInterceptor{

    @Autowired
    private TokenService tokenService;

    /**
     *  预处理回调方法   第三个参数为响应的处理器  自定义Controller
     *  return true的时候表示可以继续流程     false表示流程中断
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        ApiIdempotent idempotentAnnotation = method.getAnnotation(ApiIdempotent.class);
        if (idempotentAnnotation != null){
            check(httpServletRequest);
    }
        return true;
    }

    private void check(HttpServletRequest request) throws ServiceException {
        tokenService.checkToken(request);
    }

    /**
     *后处理回调函数  实现处理器的后处理（渲染视图之前）
     * 可以通过ModelAndView对模型数据或视图进行处理
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 整个请求完成后完成回调
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
