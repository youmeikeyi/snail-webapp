package com.snail.controllers.test;

import com.snail.controllers.test.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * User: jinchao.xu
 * Date: 14-10-21
 * Time: 上午10:54
 */
@Controller
public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping(value = "/hello2")
    public String hello(Model model, String method) {
        model.addAttribute("message", "Hello, Spring MVC");
        return "hello";
    }

    /**
     * result in the text Hello World being written to the HTTP response stream.
     *
     * @return
     */
    @RequestMapping(value = "/hello", method = RequestMethod.POST)
//    @ResponseBody
    public ModelAndView helloWorld(HttpServletRequest request, HttpServletResponse response) {
        String message = request.getParameter("hello");
        LOGGER.info("# message:" + message);
        System.out.println("# message:" + message);
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("message", "Spring MVC!");
        return mv;
    }

    /**
     * 异步验证
     * @param model
     * @param username
     */
    @RequestMapping(value = "/ajaxUser", method = RequestMethod.POST)
    public void validate(Model model, @RequestParam String username, HttpServletResponse response){
        System.out.println("validate username:" + username);
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        try {
            PrintWriter out = response.getWriter();

            if ("admin".equals(username)) {
                out.println("success");
            }else {
                out.println("failed");
            }

            out.flush();
            out.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println();
        }

        model.addAttribute("message", "valiate success");
    }

    /**
     * 作为http响应正文
     * @param userId
     * @return
     */
    @RequestMapping("/ajaxModel")
    public @ResponseBody User getUser(Integer userId){
        User user = new User();
        user.setId(userId);
        user.setUsername("test");
        user.setPassword("****");
        System.out.println("ajax model");
        return user;
    }
}
