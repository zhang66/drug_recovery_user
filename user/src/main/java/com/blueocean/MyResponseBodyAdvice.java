package com.blueocean;


import com.blueocean.common.annotation.SerializedField;
import com.blueocean.common.utils.AES;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 返回数据加密
 */
@ControllerAdvice(basePackages = "com.blueocean")
public class MyResponseBodyAdvice implements ResponseBodyAdvice {
//    private final static Logger logger = LoggerFactory.getLogger(MyResponseBodyAdvice.class);
    private final static String KEY = "!QA2Z@w1sxO*(-8L";

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        boolean encode = false;
        //增加类注解和表示
		if ( returnType.getDeclaringClass().isAnnotationPresent(SerializedField.class)){
        	returnType.getDeclaringClass();
        	//获取注解配置的包含和去除字段
        	SerializedField annotation = returnType.getDeclaringClass().getAnnotation(SerializedField.class);
        	//SerializedField serializedField = returnType.getParameterAnnotation(SerializedField.class);
        	//是否加密
        	encode = annotation.encode();
        };
        if (returnType.getMethod().isAnnotationPresent(SerializedField.class)) {
        	//获取注解配置的包含和去除字段
        	SerializedField serializedField = returnType.getMethodAnnotation(SerializedField.class);
        	//是否加密
        	encode = serializedField.encode();
        }
       if (encode) {
     //  if (false) {
          //  logger.info("对方法method :" + returnType.getMethod().getName() + "返回数据进行加密");
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                String result = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(body);
                //return AESOperator.getInstance().encrypt(result);
                return AES.getInstance().aesEncrypt(result);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return body;
    }
}