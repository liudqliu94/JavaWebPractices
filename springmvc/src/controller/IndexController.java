package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @RequestMapping 可以是一个层级的url映射
 */
@Controller
@RequestMapping("/index")
public class IndexController {

	/**
	 * 指定method为post后，再通过get请求该url，返回errorCode 405，requestMethodNotSupport
	 * 可以通过URI模板将URL中的一部分作为参数取出
	 */
	/**
	 * 
	 * @RequestParam 注解，对应绑定请求参数
	 * 如果请求的参数可能不存在，需要指定 required=false 属性
	 * value 值 必须和参数值对应，如果只指定 value 属性，可以省略
	 */
	@RequestMapping(value = "/hello/{msg}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable String msg, @RequestParam(value="id", required=false, defaultValue="1") int id) throws Exception {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("message", "Hello Spring MVC "  + msg + " " + id);
		return mav;
	}
	
	/**
	 * @ResponseBody 加与不加是有区别的，加了会将返回值写入到 HTTP 响应体中
	 * 不加将会查找名为 string 的视图
	 */
	@RequestMapping("string")
	@ResponseBody
	public String showString() {
		return "string";
	}

	@RequestMapping("/jump")
	public ModelAndView jump() {
		ModelAndView mav = new ModelAndView("redirect:/index");
		return mav;
	}

	@RequestMapping("/check")
	public ModelAndView check(HttpSession session) {
		Integer i = (Integer) session.getAttribute("count");
		if (i == null)
			i = 0;
		i++;
		session.setAttribute("count", i);
		ModelAndView mav = new ModelAndView("check");
		return mav;
	}

}