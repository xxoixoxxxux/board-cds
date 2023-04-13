package idusw.springboot.boardcds.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ProductController {
    @GetMapping
    public String goRoot() {
        return "redirect:/admin/";
    }
}
