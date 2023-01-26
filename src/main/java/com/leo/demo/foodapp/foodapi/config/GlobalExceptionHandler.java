package com.leo.demo.foodapp.foodapi.config;


import com.leo.demo.foodapp.foodapi.models.base.BaseResponse;
import com.leo.demo.foodapp.foodapi.models.base.BusinessException;
import com.leo.demo.foodapp.foodapi.models.base.ResponseCode;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResponse<Object> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        List<String> collect = fieldErrors.stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        BaseResponse<Object> response = new BaseResponse<>(ResponseCode.Code_400);
        response.setResult(collect);
        if (collect.size() > 0) {
            response.setMessage(collect.get(0));
        }

        return response;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public BaseResponse<Object> constraintViolationExceptionHandler(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        List<String> collect = constraintViolations.stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());
        BaseResponse<Object> response = new BaseResponse<>(ResponseCode.Code_400);
        response.setResult(collect);
        if (collect.size() > 0) {
            response.setMessage(collect.get(0));
        }

        return response;
    }

    @ExceptionHandler(BusinessException.class)
    public BaseResponse<Object> handleBusinessException(BusinessException e) {
        log.error(ExceptionUtils.getStackTrace(e));
        BaseResponse<Object> response = new BaseResponse<>(e.getCode(), e.getMessage());
        return response;
    }

    @ExceptionHandler(Exception.class)
    public BaseResponse<Object> handleException(Exception e) {
        log.error(ExceptionUtils.getStackTrace(e));
        BaseResponse<Object> response = new BaseResponse<>(ResponseCode.Code_1000);
        response.setResult(null);
        return response;
    }
}