package vn.techmaster.cookiedemo.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Optional;

//Ghi và lấy giá trị từ cookie
public class CookieUtil {
    private CookieUtil() {}

    //Tạo cookie
    public static Cookie createCookie(
            String name, String value,
            int expiry, boolean isSecure,
            boolean httpOnly, String path, String domain) {

        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(expiry);
        cookie.setHttpOnly(httpOnly);
        cookie.setPath(path);
        cookie.setDomain(domain);
        cookie.setSecure(isSecure);
        return cookie;
    }

    //Đọc cookie
    public static Optional<String> readCookie(HttpServletRequest request, String name) {
        if (request.getCookies() == null) {
            return Optional.ofNullable(null);
        }


        return Arrays.stream(request.getCookies())
                .filter(cookie -> name.equals(cookie.getName()))
                .map(Cookie::getValue)
                .findAny();
    }
}
