package cn.com.spring.springbootdemo.exception;

public class UserNotExitsException  extends RuntimeException {

   public UserNotExitsException(){
       super("用户不存在！！");
   }
}
