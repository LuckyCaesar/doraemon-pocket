package com.secure.login.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * web登录.
 *
 * @author xiongcaesar
 * @date 2019-01-13
 */
@RestController
@RequestMapping("/login/web/")
public class WebLoginController {

    @GetMapping("/auth")
    public String auth() {
        System.out.println("Auth ok ......");
        return "Auth OK !";
    }

}
