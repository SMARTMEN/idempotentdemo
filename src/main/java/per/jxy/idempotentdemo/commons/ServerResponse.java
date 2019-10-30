package per.jxy.idempotentdemo.commons;


import java.io.Serializable;

public class ServerResponse implements Serializable{
    private String status;
    private String msg;
    private Object date;

    public ServerResponse() {
    }

    public ServerResponse(String status, String msg, Object date) {
        this.status = status;
        this.msg = msg;
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date = date;
    }

    public static ServerResponse success(String token){
        return new ServerResponse("success",token,null);
    }

    public static ServerResponse success(String status,String msg){
        return new ServerResponse("success",msg,null);
    }

    public static ServerResponse create(String msg,String status){
        return new ServerResponse(status,msg,null);
    }
}
