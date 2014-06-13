package cn.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Name{
	String value() default "";//Name注解有一个属性为value
	 
}
