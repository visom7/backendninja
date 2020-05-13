package com.udemy.backendninja.controller;

import com.udemy.backendninja.constant.ViewConstant;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private static final Log LOGGER = LogFactory.getLog(LoginController.class);

    @GetMapping("/login")
    public String showLoginForm(Model model,
                                @RequestParam(name = "error", required = false) String error,
                                @RequestParam(name = "logout", required = false) String logout) {
        LOGGER.info("METHOD: showLoginForm() -- PARAMS: error: " + error + ", logout: " + logout);

        model.addAttribute("error", error);
        model.addAttribute("logout", logout);
        LOGGER.info("Returning to login view");
        return ViewConstant.LOGIN;
    }

    @GetMapping({"/loginsuccess", "/"})
    public String loginCheck() {
        LOGGER.info("METHOD: loginCheck()");
        LOGGER.info("Returning to contacts view");
        return "redirect:/contacts/showcontacts";

    }
}
