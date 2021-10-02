package vn.techmaster.authen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class AuthenApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(AuthenApplication.class, args);

    }

}
