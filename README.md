实现接口幂等性
    一.使用场景
		1. 订单接口，不能创建多个订单
		2. 支付接口，重复提交一笔订单只能口一次钱
		3. 支付宝回调接口，可能会出现多次回调，必须处理重复回调
		4. 普通表单提交接口，因为网络超时等原因进行多次提交，只能提交一次
    二. 解决方案
        使用redis+token机制实现接口的幂等性校验  
    三.实现思路
        为保证幂等性，需要为每一次请求创建一个token，首先获取token，并且将这个token存入redis，请求接口的时候，
        将token传到后端，在后端接口判断是否存在此token：
		* 存在则进行正常的业务处理，并且从redis中删除这个token；再进行重复请求的时候，由于已经被删除了，不能通过校验，显示请勿重复操作
		* 不存在则，说明参数不合法
    四.demo简介
		* springboot   
		* redis   
		* @ApiIdempotent注解+拦截器对请求进行拦截
		* @ControllerAdvice全局异常处理
		* 压测工具jmeter
    五.代码实现
        1. pom引入
			1.Jedis         //redis client
			2.lombok    
		2.定义注解   将其添加到需要进行幂等性测试的接口方法上
		3.自定义拦截器  主类需要继承WebMvcConfigurerAdapter 来注册自定义的拦截器
			implement HandlerInterceptor  自定义拦截器
		4.配置SpringBoot加载RedisTemplate的bean  便于操作redis