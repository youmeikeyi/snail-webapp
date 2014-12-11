package com.snail.controller.test.validator;

import com.snail.controller.test.model.Account;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * User: jinchao.xu
 * Date: 14-10-23
 * Time: 上午10:59
 */
public class AccountValidator implements Validator {

    private final Validator accountValidator;

    //reuse the exist validator account~
    public AccountValidator(Validator accountValidator) {
        if (accountValidator == null) {
            throw new IllegalArgumentException("");
        }
        if (!accountValidator.supports(Account.class)) {
            throw new IllegalArgumentException("");
        }
        this.accountValidator = accountValidator;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        //validate exactly whether clazz is Account or not
        return Account.class.equals(clazz);
        //validate Account instance,and any subclasses of it too
//        return Account.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name" ,"name.required");

        Account account = (Account) target;
        if (account.getAccountNumber() < 0) {
            errors.rejectValue("number", "negativevalue");
        }else if (account.getAccountNumber() > 1000) {
            errors.rejectValue("number", "too.darn.big");
        }

        //another validate form
        try{
            errors.pushNestedPath("account");
            ValidationUtils.invokeValidator(this.accountValidator, account.getName(), errors);
        }finally {
            errors.popNestedPath();
        }

    }
}
