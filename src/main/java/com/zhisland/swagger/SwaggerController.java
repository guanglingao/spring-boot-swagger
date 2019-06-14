package com.zhisland.swagger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
public class SwaggerController {

    @RequestMapping({"/docs","/doc","/doc.html","/api-doc","api-doc.html"})
    public ModelAndView redirect(){
        return new ModelAndView("redirect:/docs.html");
    }
}
