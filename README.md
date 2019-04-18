# SpringCloudDemo
这是一个SpringCloud项目的Demo
#### 介绍
暂无
#### 项目架构
项目使用SpringCloud+SpringBoot构建的微服务架构,目前主要集成:  

	1.Netflix的Eureka服务注册于发现,访问地址为:http://localhost:8761  
	
	2.Ribbon+RestTemplate+Hystrix实现负载均衡和熔断机制,访问地址为:http://localhost:8764/hi?message=HelloRibbon (实际开发中基本不使用这种方式)  
	
	3.Feign负载均衡和熔断机制,访问地址:http://localhost:8765/hi?message=HelloFeign (实际开发中常用方式)  
	4.Hystrix熔断器仪表盘监控,访问地址:http://localhost:8765/hystrix (仅配置了Feign的仪表盘监控,Ribbon配置方式一样)  
	5.Zuul路由网关集群和拦截器机制,访问地址:① http://localhost:8769/api/feign/hi?message=HelloZuul&token=123  
											② http://localhost:8769/api/ribbon/hi?message=HelloZuul&token=123  
	6.config分布式配置中心,实现yml配置文件存放于远程GitHub仓库  
	7.zipkin链路追踪,访问地址:http://localhost:9411/
	8.Admin服务监控,访问地址:http://localhost:8084
#### 项目启动顺序
	SpringCloudEureka → SpringCloudConfig → SpringCloudAdminServer、SpringCloudZipkin → SpringCloudServiceAdmin
	→ SpringCloudWebAdminFeign、SpringCloudWebAdminRibbon → SpringCloudZuul