package com.snail.controller.test.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

/**
 * in order to support for @ResponseBody and ResponseEntity methods
 * User: jinchao.xu
 * Date: 14-10-27
 * Time: 上午10:39
 */
@ControllerAdvice
public class JsonpAdvice extends AbstractJsonpResponseBodyAdvice {

    public JsonpAdvice(){
        super("callback");
    }
}
