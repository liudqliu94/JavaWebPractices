**SringMVC**
1. [Spring 官方文档](https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc)
2. [中文翻译，基于4.2.4版本](https://spring-mvc.linesh.tw/)

**SpringMVC官方文档小摘**
1. SpringMVC的核心是DispatcherServlet
2. SpringMVC集成了一些特殊的bean来实现特定的功能：HandlerMapping, HandlerExceptionResolver, ViewResolver, LocaleResolver&LocaleContextResolver, MultiPartResolver等
3. [DispatcherServlet处理流程](https://spring-mvc.linesh.tw/publish/21-2/3-dispatcherservlet-processing-sequence.html)
4. 定义 @RequestMapping 处理的方法可以接受的参数中可能使用的注解：@PathVariable, @MatrixVariable, @RequestParam, @RequestHeader, @RequestBody
5. 定义 @RequestMapping 处理的方法的返回值：基本是可以任意对象，但是某些对象可能会被处理，比如String最终会被解析成一个逻辑视图名（如果需要直接返回String，可以通过@ResponseBody注解实现，该注解会return type 写到 http 响应体中去，而不是被放置在Model或者被解释为一个视图）
6. @RestController = @Controller + @ResponseBody
7. 可以通过 @CookieValue 获取 cookie

**SpringMVC code 内容**
1. HelloWorld
2. 注解  @Controller, @RequestMapping
3. 拦截器（HandlerInterceptor）
4. 视图解析（ViewResolver），redirect，forward
5. 文件处理，multipartfile
6. 简单的session管理
