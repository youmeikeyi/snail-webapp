package com.snail.controllers;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha512Hash;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.Date;

/**
 * User: jinchao.xu
 * Date: 14-11-19
 * Time: 下午3:14
 */
@Controller
public class ShiroController {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    /**
     * load .ini file in resource package
     * @param model
     * @return
     */
    @RequestMapping("shiro")
    public String index(Model model, String username, String password) {
        LOGGER.info("in shiro");

        String shiroIni = "classpath:shiro.ini";
        //1. load ini conf file
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(shiroIni);

        //2.create sm
        SecurityManager securityManager = factory.getInstance();

        //3. make it accessable
        SecurityUtils.setSecurityManager(securityManager);

        ////////////////////Subject login
        //1. get principle and credential
        AuthenticationToken token = new UsernamePasswordToken(username, password);
        //2. get current subject
        Subject currentUser = SecurityUtils.getSubject();
        //3 login
        try {
            currentUser.login(token); // may throw authentication exception
        } catch (IncorrectCredentialsException ice) {
        } catch (LockedAccountException lae) {
        } catch (AuthorizationException ae) {
            System.out.println(ae);
        }

        Session session = currentUser.getSession();
        Session session1 = currentUser.getSession(true);
        model.addAttribute("message", "Hello, Spring MVC");

        session.getAttribute("key");
        Date start = session.getStartTimestamp();
        Date timestamp = session.getLastAccessTime();
        session.setTimeout(1000);

        //simplify hash, jdk has a complex method
        String hex = new Md5Hash(new File("")).toHex();
        String encodePwd = new Sha512Hash("", new Object(), 2).toBase64();

        //jia mi
        AesCipherService cipherService = new AesCipherService();
        cipherService.setKeySize(256);
        //create a test secret key
        byte[] testKey = cipherService.generateNewKey().getEncoded();
        //
        byte[] text = new byte[]{1,2,3};
//        byte[] encrypted = cipherService.encrypt(text, testKey);

        return "index";
    }

    @RequestMapping("collect")
    public ModelAndView  test(String username, String password){
        ModelAndView mv = new ModelAndView("index");

        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        token.setRememberMe(true);
        //get subject, maybe a man or process ..
        Subject currentUser = SecurityUtils.getSubject();

        //manage all users' security operations
//        SecurityManager

        return mv;
    }
}
