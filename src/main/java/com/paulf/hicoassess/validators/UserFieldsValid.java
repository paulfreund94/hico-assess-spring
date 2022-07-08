package com.paulf.hicoassess.validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserFieldValidValidator.class)
public @interface UserFieldsValid {

  String message() default "User fields not valid.";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
