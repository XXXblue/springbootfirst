package com.xjy.springbootfirst.exception;
import com.xjy.springbootfirst.utils.Result;
import com.xjy.springbootfirst.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;



/**
 * @Author: XBlue
 * @Date: Create in 2018/6/29:37
 * @Description: 全局异常处理器
 * @Modified By:
 */
@ControllerAdvice
public class ExceptionHandler {
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    @ResponseBody
    public Result hander(Exception e){
        if(e instanceof  MyException){
            //json返回可处理的异常
            MyException myException = (MyException) e;
            return ResultUtil.error(myException.getCode(),e.getMessage());
        }else{
            logger.error(e.getMessage());
            e.printStackTrace();
            //json返回不可处理的异常
            return ResultUtil.error(900,"系统错误");
        }
    }
}
