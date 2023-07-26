package top.mark.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    /**
     * 
     * @param model
     * @return
     */
    @GetMapping("/toLogin")
    public String hello(Model model) {
        model.addAttribute("hello", "hello world");
        return "login/login";
    }
}
