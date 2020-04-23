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
	 * preHandle �� ����ֵ�������Ƿ����ִ�к�������
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("preHandler, controller ֮ǰ");
		return true;
		
		/**
		 * ���磺����ĳ���ж�����result��������㣬��������ִ�У���������controller���߼�����������㣬ֱ���ض��򵽴���ҳ�棬�Ժ���߼�������ִ��
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
        System.out.println("postHandle, Controller֮����ͼ֮ǰ");
        modelAndView.addObject("date", "�����������ɵ�ʱ��:" + new Date());
    }
    
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
    		throws Exception {
    	System.out.println("afterCompletion, ��ͼ֮��");
    }
	
}
