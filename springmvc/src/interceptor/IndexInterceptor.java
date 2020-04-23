package interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class IndexInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("preHandler, controller 之前");
		return true;
	}
	
	@Override
    public void postHandle(HttpServletRequest request,   
            HttpServletResponse response, Object handler,   
            ModelAndView modelAndView) throws Exception { 
        System.out.println("postHandle, Controller之后，视图之前");
        modelAndView.addObject("date", "由拦截器生成的时间:" + new Date());
    }
    
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
    		throws Exception {
    	System.out.println("afterCompletion, 视图之后");
    }
	
}
