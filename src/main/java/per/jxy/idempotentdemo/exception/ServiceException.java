package per.jxy.idempotentdemo.exception;

public class ServiceException extends Exception {
    private String exceptionMsg;

    public ServiceException(String exceptionMsg) {
        super();
        this.exceptionMsg = exceptionMsg;
    }
    public String getExceptionMsg(){
        return this.exceptionMsg;
    }

}
