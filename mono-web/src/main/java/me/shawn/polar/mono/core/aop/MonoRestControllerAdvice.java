package me.shawn.polar.mono.core.aop;

import lombok.extern.slf4j.Slf4j;
import me.shawn.polar.mono.model.CommonResponseModel;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@Slf4j
@RestControllerAdvice
public class MonoRestControllerAdvice implements ResponseBodyAdvice<Object> {

    public static final String SUCCESS = "SUCCESS";

    public MonoRestControllerAdvice() {
        log.info("advice !!!");
    }

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        log.info("==before body write==");
        log.info(body.toString());
        log.info(body.getClass().toString());

        CommonResponseModel modifiedResponse = CommonResponseModel.builder()
                .status(HttpStatus.OK)
                .message(SUCCESS)
                .data(body)
                .build();

        if("class java.lang.String".equals(returnType.getMethod().getReturnType().toString())) {
            log.info("return type is String!");
            return modifiedResponse.toJson();
        }
        return modifiedResponse;
    }

}
