package com.hand.testonetomore.annotation;

import java.lang.annotation.*;

/**
 * @author 谭春
 * Date: 2019/7/17
 * Description:
 */

@Target(value = {ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface PermissionAnnotation {
    boolean value() default false;
}

