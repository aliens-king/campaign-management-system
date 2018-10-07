/**
 * 
 */
package com.sampana.cms.dto.service;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;



/**
 * @author Sudhanshu Chaturvedi
 */
@Target({ElementType.FIELD, ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserDTOValidatorCustom.class)
@Documented
public @interface IsUserDTOPropertiesValid {
	 String message() default "Please Enter a Valid Password";
	 
	    Class<?>[] groups() default {};
	 
	    Class<? extends Payload>[] payload() default {};
}
