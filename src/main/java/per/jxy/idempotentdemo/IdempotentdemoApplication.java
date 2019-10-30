package per.jxy.idempotentdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import per.jxy.idempotentdemo.interceptor.ApiIdempotentInterceptor;

@SpringBootApplication
@ComponentScan(basePackages = {"per.jxy.idempotentdemo.*"})
public class IdempotentdemoApplication{

	public static void main(String[] args) {
		SpringApplication.run(IdempotentdemoApplication.class, args);
	}

}
