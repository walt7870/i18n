package com.example.i18n.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;

@Controller
public class LocaleController {
    Logger logger= LoggerFactory.getLogger(LocaleController.class);

    @RequestMapping(value = "/locale", method = RequestMethod.GET)
    public ModelAndView getLocalePage(String lang) {
        ModelAndView modelAndView=new ModelAndView("my-locale");
        Locale locale = LocaleContextHolder.getLocale();  //获取区域信息
        String welcome = messageSource.getMessage("greeting",null,locale);
//        return welcome;
        logger.info(lang);
        logger.info(welcome);
        modelAndView.addObject("langLocal",lang);
        return modelAndView;
    }

    @Autowired
    private MessageSource messageSource;

    @RequestMapping("/hello")
    public String hello(){
        Locale locale = LocaleContextHolder.getLocale();  //获取区域信息
        String welcome = messageSource.getMessage("greeting",null,locale);
//        return welcome;
        System.out.println(welcome);
        return "hello";
    }

}
