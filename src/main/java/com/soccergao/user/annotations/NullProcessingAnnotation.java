package com.soccergao.user.annotations;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NullProcessingAnnotation {
    boolean isThrowException() default false;

    int[] argsIndex() default {0};
}
