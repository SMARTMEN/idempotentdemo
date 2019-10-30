package per.jxy.idempotentdemo.impl;

import org.springframework.stereotype.Service;
import per.jxy.idempotentdemo.commons.ServerResponse;
import per.jxy.idempotentdemo.service.TestIdempotent;

@Service
public class TestIdepotentImpl implements TestIdempotent{
    @Override
    public ServerResponse testIdempotent() {
        System.out.println("你看看我是唯一一次吗？");
        return ServerResponse.success("success","你是唯一一个可以进来请求的");
    }
}
