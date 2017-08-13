package com.softserve.edu.lv251.validators;

import com.softserve.edu.lv251.customannotations.ValidPassword;
import org.passay.*;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Added by Pavlo Kuchereshko.
 */
public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {
    @Override
    public void initialize(ValidPassword arg0) {
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {

        PasswordValidator validator = new PasswordValidator(Arrays.asList(
                new LengthRule(8, 30),
                new WhitespaceRule()));

        RuleResult ruleResult = validator.validate(new PasswordData(password));
        if (ruleResult.isValid()) {
            return true;
        }

        constraintValidatorContext.disableDefaultConstraintViolation();
        constraintValidatorContext.buildConstraintViolationWithTemplate(validator.getMessages(ruleResult)
                .stream().collect(Collectors.joining(System.lineSeparator()))).addConstraintViolation();

        return false;
    }
}
