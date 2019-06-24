package com.jt.abandon.spring.cloud.auth.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @createData: 2019-06-24 15:55
 * @author: LongJunTao
 * @Description:
 */
@Controller
@RequestMapping("/")
public class LoginController {
    @RequestMapping("/login")
    public String showLogin(String redirect, Model model) {
        model.addAttribute("redirect", redirect);
        return "login";
    }
}
