package com.jumper.pdf.common;


import com.jumper.pdf.common.SensitiveInfoUtils;

import java.lang.annotation.*;


@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface SensitiveInfo {

    public SensitiveInfoUtils.SensitiveType type() ;
}
