package top.mark.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * IndexController
 * 
 * @author shenjunyu
 * @since 2023-07-27
 */
@Controller
public class IndexController {

    /**
     * 跳转到首页
     * 
     * @return
     */
    @GetMapping({"/", "/index"})
    public String index() {
        return "blog/list";
    }
}
