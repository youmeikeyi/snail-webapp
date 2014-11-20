package com.snail.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User: jinchao.xu
 * Date: 14-10-21
 * Time: 上午10:57
 */
@Controller("")
@RequestMapping("/")
public class IndexController {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping("")
    public String index(Model model) {
        LOGGER.info("in index");
        model.addAttribute("message", "Hello, Spring MVC");
        return "/index";
    }

    @RequestMapping("hello")
    @ResponseBody
    public String hello() {
        return "hello world";
    }

}
