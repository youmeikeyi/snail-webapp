package com.snail.controllers.test;

import com.fasterxml.jackson.annotation.JsonView;
import com.snail.controllers.test.model.Person;
import com.snail.controllers.test.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: jinchao.xu
 * Date: 14-10-23
 * Time: 下午3:45
 */
@RestController
public class UserController {

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    @JsonView(User.WithoutPasswordView.class)
    public Person getPerson(){
        return new Person();
    }


}
