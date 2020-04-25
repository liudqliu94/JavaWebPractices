## 目录
-[SpringMVC](#SpringMVC)

-[Mybatis](#MyBatis)

-[SSM](#SSM)

## SringMVC
1. [SpringMVC 官方文档](https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc)
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

## Mybatis
[官方中文文档](https://mybatis.org/mybatis-3/zh/index.html)

**Code内容**
1. mysql数据库
2. sql脚本：创建数据库，创建表格，插入初始数据。表格包括：品类表，产品表，订单表，订单产品表，一个品类包含多个产品，一个产品对应一个品类；一个产品可能包含在多个订单中，一个订单可能包含多个产品；订单、产品是一个多对多关系，因此引入一个中间表，转换成两个多对一关系。
3. 针对基本操作进行测试，对比数据库查看结果。
4. 针对 xml 以及 注解 两种方式分别做demo
5. 分页 PageHelper
6. log4j 开启日志
7. 缓存 [美团技术团队有一篇文章比较详细，其中是不建议使用mybatis自带的缓存的，同时建议将一级缓存设置为 statement](https://tech.meituan.com/2018/01/19/mybatis-cache.html)



## SSM

