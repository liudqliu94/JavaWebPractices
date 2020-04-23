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
 * @RequestMapping ������һ���㼶��urlӳ��
 */
@Controller
@RequestMapping("/index")
public class IndexController {

	/**
	 * ָ��methodΪpost����ͨ��get�����url������errorCode 405��requestMethodNotSupport
	 * ����ͨ��URIģ�彫URL�е�һ������Ϊ����ȡ��
	 */
	/**
	 * 
	 * @RequestParam ע�⣬��Ӧ���������
	 * �������Ĳ������ܲ����ڣ���Ҫָ�� required=false ����
	 * value ֵ ����Ͳ���ֵ��Ӧ�����ָֻ�� value ���ԣ�����ʡ��
	 */
	@RequestMapping(value = "/hello/{msg}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable String msg, @RequestParam(value="id", required=false, defaultValue="1") int id) throws Exception {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("message", "Hello Spring MVC "  + msg + " " + id);
		return mav;
	}
	
	/**
	 * @ResponseBody ���벻����������ģ����˻Ὣ����ֵд�뵽 HTTP ��Ӧ����
	 * ���ӽ��������Ϊ string ����ͼ
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