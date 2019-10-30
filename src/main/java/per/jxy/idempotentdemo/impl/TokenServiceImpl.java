package per.jxy.idempotentdemo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import per.jxy.idempotentdemo.commons.Constant;
import per.jxy.idempotentdemo.commons.ServerResponse;
import per.jxy.idempotentdemo.exception.ServiceException;
import per.jxy.idempotentdemo.service.TokenService;
import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Service
public class TokenServiceImpl implements TokenService{

    private static final String TOKEN_NAME = "token";

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public ServerResponse createToken() {
        String str = UUID.randomUUID().toString();
        StringBuilder token = new StringBuilder();
        token.append(Constant.redisPrefix).append(str);
        redisTemplate.opsForValue().set(TOKEN_NAME,token.toString(),100000);
        return ServerResponse.success(token.toString());
    }

    @Override
    public void checkToken(HttpServletRequest request) throws ServiceException {
        //首先从header 获取token
        String token = request.getHeader(TOKEN_NAME);
        if (token == null){  //header中没有token
            token = request.getParameter(TOKEN_NAME);
            if(StringUtils.isEmpty(token)){
                throw new ServiceException("非法请求");
            }
        }
        if (!redisTemplate.hasKey(token)){
            throw new ServiceException("不能重复请求");
        }
        //需要根据能否成功删除来判断是否重复请求了
        redisTemplate.delete(token);
    }
}
