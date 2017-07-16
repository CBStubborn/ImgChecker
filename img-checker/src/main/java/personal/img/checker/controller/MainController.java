package personal.img.checker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Stubborn on 2017/4/8.
 */
@Controller
public class MainController {

    @RequestMapping("/")
    public String index() {
        return "redirect:/img-checker/";
    }

    @RequestMapping("/img-checker")
    public String index_2() {
        return "redirect:/img-checker/";
    }
}
