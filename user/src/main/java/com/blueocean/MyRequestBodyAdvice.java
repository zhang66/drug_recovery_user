package com.blueocean;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import com.blueocean.common.annotation.isNotDecrypt;
import com.blueocean.common.utils.AES;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;

/**
 * 请求数据解密
 */
@ControllerAdvice(basePackages = "com.blueocean")
public class MyRequestBodyAdvice implements RequestBodyAdvice {
  //  private final static Logger logger = LoggerFactory.getLogger(MyResponseBodyAdvice.class);
    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return body;
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
        try {
        	boolean encode=true;
        	  //增加类注解和表示
    		if ( parameter.getDeclaringClass().isAnnotationPresent(isNotDecrypt.class)){
            	//获取注解配置的包含和去除字段
    			isNotDecrypt annotation = parameter.getDeclaringClass().getAnnotation(isNotDecrypt.class);
            	//是否加密
            	encode = annotation.encode();
            };
        if(	parameter.getMethod().isAnnotationPresent(isNotDecrypt.class)){
        	isNotDecrypt methodAnnotation = parameter.getMethodAnnotation(isNotDecrypt.class);
        	 encode = methodAnnotation.encode();
        }
        if(encode){
 //       if(false){
            return new MyHttpInputMessage(inputMessage);
            }else{
            	return inputMessage;
            }
        
        } catch (Exception e) {
            e.printStackTrace();
            return inputMessage;
        }
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return body;
    }

    class MyHttpInputMessage implements HttpInputMessage {
        private HttpHeaders headers;

        private InputStream body;

        public MyHttpInputMessage(HttpInputMessage inputMessage) throws Exception {
            this.headers = inputMessage.getHeaders();
         
           // this.body = IOUtils.toInputStream(AESOperator.getInstance().decrypt(IOUtils.toString(inputMessage.getBody(), "UTF-8")), "UTF-8");
            this.body = IOUtils.toInputStream(AES.getInstance().aesDecrypt(IOUtils.toString(inputMessage.getBody(), "UTF-8")), "UTF-8");
        }

        @Override
        public InputStream getBody() throws IOException {
            return body;
        }

        @Override
        public HttpHeaders getHeaders() {
            return headers;
        }
    }
}