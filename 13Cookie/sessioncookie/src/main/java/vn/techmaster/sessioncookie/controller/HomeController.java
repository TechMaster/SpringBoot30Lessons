package vn.techmaster.sessioncookie.controller;

import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import vn.techmaster.sessioncookie.util.CookieUtil;

@Controller
public class HomeController {
  @GetMapping({"/", "/color/{color}"})
  public String showHome(
    @PathVariable(required = false) String color,
    HttpServletRequest request,
    HttpServletResponse response,
    Model model) {

    if (color != null) {
      Cookie bgColor = CookieUtil.createCookie(
      "bgColor",    //Key
      color,        //Value
      10,           //Số giây cho đến khi hết hạn
      true,        //isSecured, yêu cầu cookie gửi lên bằng HTTPS
      false,        //HttpOnly, nếu bằng true thì javascript phía client sẽ không đọc được, chỉ server đọc
      "/",          //cookie này có hiệu lực từ đường dẫn nào
      request.getServerName()); //server nào

      Cookie trace = CookieUtil.createCookie(
        "trace",    //Key
        "ox-13",        //Value
        10,           //Số giây cho đến khi hết hạn
        true,        //isSecured, yêu cầu cookie gửi lên bằng HTTPS
        false,        //HttpOnly, nếu bằng true thì javascript phía client sẽ không đọc được, chỉ server đọc
        "/other",          //cookie này có hiệu lực từ đường dẫn nào
        request.getServerName()); //server nào

      response.addCookie(bgColor);
      response.addCookie(trace);
    } else {
      Optional<String> cookie = CookieUtil.readCookie(request, "bgColor");
      if (cookie.isPresent()) {
        System.out.println(cookie.get());
      }
    }   
    return "index";
  }

  @GetMapping("/other")
  public String otherPage(HttpServletRequest request) {
    Optional<String> cookie = CookieUtil.readCookie(request, "trace");
    if (cookie.isPresent()) {
      System.out.println(cookie.get());
    }
    return "other";
  }
}
