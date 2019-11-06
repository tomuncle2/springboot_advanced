package com.caidi.springbootadvanced.exception;

import com.caidi.springbootadvanced.domain.Result;
import com.caidi.springbootadvanced.enums.ResultCodeEnum;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 默认异常返回信息
 */
@ControllerAdvice
public class DefaultExceptionHandler {

    public static Logger LOGGER = LoggerFactory.getLogger(DefaultExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler({Throwable.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<Object> handleThrowable(HttpServletRequest request, Throwable e) {
        LOGGER.error("execute method exception error.url is {}", request.getRequestURI(), e);
        return Result.failure(e, ResultCodeEnum.INTERNAL_SERVER_ERROR);
    }

    /**
     * 没有权限 异常
     * <p/>
     * 后续根据不同的需求定制即可
     */
    @ExceptionHandler({UnauthorizedException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Result handleUnauthenticatedException(HttpServletRequest request, UnauthorizedException e) {
        LOGGER.error("execute method exception error.url is {}", request.getRequestURI(), e);
        return Result.failure(ResultCodeEnum.UNAUTHORIZED, e.getMessage());
    }

    /**
     * 系统异常
     * @param request
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler({RuntimeException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Result handleUnauthenticatedException(HttpServletRequest request, RuntimeException e) {
        Result baseResponse = new Result();
        LOGGER.error("execute method exception error.url is {}", request.getRequestURI(), e);
        baseResponse.setErrorMsg("服务异常");
        baseResponse.setMsg(e.getMessage());
        baseResponse.setCode("490");
        return baseResponse;
    }

    /**
     * 服务异常
     *
     * @param request
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler({JxbException.class})
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    public Result handleBizException(HttpServletRequest request, JxbException e) {
        Result baseResponse = new Result();
        LOGGER.error("execute method exception error.url is {}", request.getRequestURI(), e);
        baseResponse.setErrorMsg("服务异常");
        baseResponse.setMsg(e.getMessage());
        baseResponse.setCode("490");
        return baseResponse;
    }

    /**
     * 参数校验异常
     *
     * @param request
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler({BindException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result handleBindException(HttpServletRequest request, BindException e, BindingResult br) {
        LOGGER.error("execute method exception error.url is {}", request.getRequestURI(), e);
        return Result.failure(br);
    }

    /**
     * 拦截MethodArgumentNotValidException异常
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Result handleMethodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException e){
        Result baseResponse = new Result();
        LOGGER.error("execute method exception error.url is {}", request.getRequestURI(), e);
        baseResponse.setErrorMsg("请求参数不能为空");
        List<String> errorMsgs = new ArrayList<>();
        e.getBindingResult().getAllErrors().forEach(error->errorMsgs.add(error.getDefaultMessage()));
        baseResponse.setMsg(errorMsgs.toString().substring(1,errorMsgs.toString().length()-1));
        baseResponse.setCode("483");
        return baseResponse;
    }

    /**
     * 处理get请求参数必传的问题
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Result handleMissingServletRequestParameterException(HttpServletRequest request, MissingServletRequestParameterException e){
        Result baseResponse = new Result();
        LOGGER.error("execute method exception error.url is {}", request.getRequestURI(), e);
        baseResponse.setErrorMsg("请求参数不能为空");
        baseResponse.setMsg(e.getMessage().split("'")[1]+"不能为空！");
        baseResponse.setCode("483");
        return baseResponse;
    }

    /**
     * 参数类型转换错误捕获
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Result handleIllegalArgumentException(HttpServletRequest request, MethodArgumentTypeMismatchException e){
        Result baseResponse = new Result();
        LOGGER.error("execute method exception error.url is {}", request.getRequestURI(), e);
        baseResponse.setErrorMsg("参数类型异常");
        baseResponse.setMsg(e.getName()+"参数类型异常,请求参数类型必须为："+e.getRequiredType());
        baseResponse.setCode("483");
        return baseResponse;
    }

    /**
     * 请求参数类型异常处理
     *
     * @Param
     * @return
     * @Date  2019/1/21 11:34
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Result requestNotReadable(HttpServletRequest request, HttpMessageNotReadableException e, MismatchedInputException mismatchedInputException) {
        Result baseResponse = new Result();
        LOGGER.error("execute method exception error.url is {}", request.getRequestURI(), e);
        baseResponse.setErrorMsg("请求参数类型异常");
        baseResponse.setMsg(mismatchedInputException.getPath().get(0).getFieldName()+"参数类型异常,请求参数类型必须为："+ mismatchedInputException.getTargetType().getName());
        baseResponse.setCode("483");
        return baseResponse;
    }

}
