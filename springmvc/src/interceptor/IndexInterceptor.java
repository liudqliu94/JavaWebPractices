package interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class IndexInterceptor extends HandlerInterceptorAdapter{

	/**
	 * preHandle 的 返回值决定了是否继续执行后续步骤
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("preHandler, controller 之前");
		return true;
		
		/**
		 * 比如：根据某个判断条件result，如果满足，继续后续执行，包括正常controller的逻辑，如果不满足，直接重定向到错误页面，以后的逻辑都不在执行
		 */
//		boolean result;
//		if (result) {
//			return true;
//		}
//		response.sendRedirect("errorPage.jsp");
//		return false;
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
