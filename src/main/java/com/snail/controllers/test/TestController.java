package com.snail.controllers.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;

/**
 * User: jinchao.xu
 * Date: 14-10-15
 * Time: 下午2:33
 */
public class TestController extends AbstractController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @RequestMapping(value = "test1", method = RequestMethod.GET)
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String message = request.getParameter("hello");
        LOGGER.info("# message:" + message);
        System.out.println("# message:" + message);
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("message", "Spring MVC!");
        return mv;
    }

    @RequestMapping(value = "test2", method = RequestMethod.GET)
    public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String message = request.getParameter("hello");
        LOGGER.info("# message:" + message);
        System.out.println("# message:" + message);
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("message", "Spring MVC!");
        return mv;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String setupForm(@RequestParam(value = "id", required = false) int id, ModelMap modelMap) {

        return "form";
    }

    @RequestMapping(value = "/some", method = RequestMethod.PUT)
    public void handle(@RequestBody String body, Writer writer) {
        try {
            writer.write(body);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    @RequestMapping("/httptest")
    public ResponseEntity<String> handle(HttpEntity<byte[]> requestEntity) {
        String requestHeader = requestEntity.getHeaders().getFirst("myRequestHeaders");
        byte[] requestBody = requestEntity.getBody();
        //---------

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("myResponseHeader", "myValue");
        return new ResponseEntity<String>("heelo", responseHeaders, HttpStatus.CREATED);
    }

    /**
     * add one model attribute , default name "account" based on its type
     *
     * @param number
     * @return
     */
    /*@ModelAttribute
    public Account addAccount(@RequestParam String number) {
        return new Account();
    }

    @ModelAttribute
    public void populateModel(@RequestParam String number, Model model) {
        // add more model attribute
        model.addAttribute("");
        model.addAttribute("");
    }

    @RequestMapping(value = "/accounts/{account}", method = RequestMethod.PUT)
    public String save(@ModelAttribute("account") Account account) {
        return "";
    }

    @RequestMapping(value = "/.../edit", method = RequestMethod.POST)
    public String processSubmit(@Valid @ModelAttribute("account") Account account, BindingResult result) {

        //invoke validation or use annatation @Valid
//        new AccountValidator().validate(account, result);
        if (result.hasErrors()) {
            return "error";
        }
        return "";
    }*/

    /**
     * 绑定Cookie值 请求头值
     *
     * @param cookie
     */
    @RequestMapping("/displayheader")
    public void displayHeaderInfo(@CookieValue("JSESSIONID") String cookie,
                                  @RequestHeader("Accept-Encoding") String encoding,
                                  @RequestHeader("Keep-Alive") long keepAlive) {
        //

    }

    /**
     * 定制数据绑定
     *
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    /**
     * asynchronous request processing
     * @param file
     * @return
     */
    public Callable<String> processUpload(final MultipartFile file) {
        //instead of returning a value, this method return a Callable;
        //and produce the return value from a separate thread .
        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                //...
                return "someView";
            }
        };
    }

    @RequestMapping("/quotes")
    @ResponseBody
    public DeferredResult<String> quotes(){
        DeferredResult<String> deferredResult = new DeferredResult<String>();
        // save the deferredResult in in-memory queue...
        return deferredResult;

        //in some other thread ...
//        deferredResult.setResult(data);
    }


}
