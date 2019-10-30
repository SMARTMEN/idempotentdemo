package per.jxy.idempotentdemo.service;

import per.jxy.idempotentdemo.commons.ServerResponse;
import per.jxy.idempotentdemo.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

public interface TokenService {

    ServerResponse createToken();

    void checkToken(HttpServletRequest request) throws ServiceException;


}
