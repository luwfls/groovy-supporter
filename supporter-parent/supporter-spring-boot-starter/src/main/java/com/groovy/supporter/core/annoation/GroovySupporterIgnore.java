package com.groovy.supporter.core.annoation;

import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER,ElementType.METHOD})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface GroovySupporterIgnore {

}
