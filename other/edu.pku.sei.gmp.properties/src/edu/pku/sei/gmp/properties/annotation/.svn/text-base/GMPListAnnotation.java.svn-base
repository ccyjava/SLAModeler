package edu.pku.sei.gmp.properties.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface GMPListAnnotation {
	public Class<?> allowedType() default Object.class;
	public String newInstanceMethod() default "newInstance";
	public String getCommandStackMethod() default "getCommandStack";
	public String typeString() default "";
}
