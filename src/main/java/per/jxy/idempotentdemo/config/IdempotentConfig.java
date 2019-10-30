package per.jxy.idempotentdemo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import per.jxy.idempotentdemo.interceptor.ApiIdempotentInterceptor;

@Configuration
public class IdempotentConfig extends WebMvcConfigurerAdapter{

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ApiIdempotentInterceptor());
        super.addInterceptors(registry);

    }


}
