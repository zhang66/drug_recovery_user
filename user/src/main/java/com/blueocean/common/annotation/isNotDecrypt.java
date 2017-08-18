package com.blueocean.common.annotation;

import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Mapping
public @interface isNotDecrypt {
    /**
     * 是否加密
     * @return
     */
    boolean encode() default false;
}