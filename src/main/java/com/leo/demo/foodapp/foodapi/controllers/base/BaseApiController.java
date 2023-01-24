package com.leo.demo.foodapp.foodapi.controllers.base;


import com.leo.demo.foodapp.foodapi.models.base.BaseRequest;
import com.leo.demo.foodapp.foodapi.models.base.BaseResponse;
import com.leo.demo.foodapp.foodapi.models.base.BusinessException;
import com.leo.demo.foodapp.foodapi.models.base.ResponseCode;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;

/**
 * @author leo
 * @date 2023/1/17
 */
public class BaseApiController {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    protected <T extends BaseRequest, R> BaseResponse<R> execService(T request, Function<T, R> function) {
        BaseResponse<R> baseResponse = new BaseResponse<>();
        try {
            log.info(String.format("【Request】%s ", request));
            R result = function.apply(request);
            baseResponse.setResult(result);
        } catch (BusinessException e) {
            log.warn(e.getCode(), e.getMessage(), "", "");
            baseResponse.setResult(null);
            baseResponse.setCode(e.getCode());
            baseResponse.setMessage(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage() + "|" + ExceptionUtils.getStackTrace(e));
            baseResponse.setResult(null);
            baseResponse.setCode(ResponseCode.Code_1000.getCode());
            baseResponse.setMessage(ResponseCode.Code_1000.getMessage());
        }
        log.info(String.format("【Response】%s", baseResponse));
        return baseResponse;
    }
}
