package com.akoca.mvc.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode , String> {

    private String[] coursePrefix;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        if(null == s) {
            return false;
        }

        for(String str : coursePrefix) {
            if(s.startsWith(str)) {
                System.out.println("returning true");
                return true;
            }
        }

        return false;
    }

    @Override
    public void initialize(CourseCode constraintAnnotation) {
        coursePrefix = constraintAnnotation.value();
    }
}