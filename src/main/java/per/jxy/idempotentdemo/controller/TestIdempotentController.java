package per.jxy.idempotentdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.jxy.idempotentdemo.annotation.ApiIdempotent;
import per.jxy.idempotentdemo.commons.ServerResponse;
import per.jxy.idempotentdemo.service.TestIdempotent;
import per.jxy.idempotentdemo.service.TokenService;

@RestController
@RequestMapping("/test/")
@CrossOrigin(allowCredentials = "true",allowedHeaders = {"*"},origins = {"*"})
public class TestIdempotentController extends BaseController{

    @Autowired
    private TokenService tokenService;

    @Autowired
    private TestIdempotent testIdempotent;

    @GetMapping("getToken")
    public ServerResponse getToken(){
        return tokenService.createToken();
    }

    @ApiIdempotent
    @RequestMapping("testIdempotent")
    public ServerResponse testIdempotent(){
        return testIdempotent.testIdempotent();
    }
}
