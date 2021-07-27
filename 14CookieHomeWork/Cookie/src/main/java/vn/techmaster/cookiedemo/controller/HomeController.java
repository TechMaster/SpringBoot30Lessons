package vn.techmaster.cookiedemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import vn.techmaster.cookiedemo.model.Style;
import vn.techmaster.cookiedemo.util.CookieUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {
    @GetMapping("/")
    public String showHome(){

        return "index";
    }

    @GetMapping("/blog")
    public String showBlog(){
        return "blog";
    }
    @GetMapping("/setting")
    public String showSetting(Model model){
        model.addAttribute("style",new Style());
        return "setting";
    }

    //Lưu giá trị vào cookie
    @PostMapping("/save")
    public String saveSetting(@ModelAttribute("style") Style style, BindingResult result, Model model,
                              HttpServletRequest request,
                              HttpServletResponse response){
        Cookie bgColor = CookieUtil.createCookie("bgColor", style.getBackground(),
                100, true,
                false,
                "/",
                request.getServerName()
        );

        Cookie color = CookieUtil.createCookie("color", style.getColor(),
                100, true,
                false,
                "/",
                request.getServerName()
        );

        Cookie font = CookieUtil.createCookie("font", style.getFont(),
                100, true,
                false,
                "/",
                request.getServerName()
        );

        response.addCookie(bgColor);
        response.addCookie(color);
        response.addCookie(font);

        return "index";
    }
}
