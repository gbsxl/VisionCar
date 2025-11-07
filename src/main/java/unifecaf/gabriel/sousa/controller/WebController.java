package unifecaf.gabriel.sousa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/interface")
    public String index(){
        return "index.html";
    }
}
