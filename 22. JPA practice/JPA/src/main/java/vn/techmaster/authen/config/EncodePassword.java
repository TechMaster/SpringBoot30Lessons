package vn.techmaster.authen.config;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

public class EncodePassword {
    public static void main(String[] args) {
        List<String> passwords = List.of("123","456","qmd","tmc","phl","mds","ha2002","abc","def");
        for(var password:passwords){
            System.out.println(BCrypt.hashpw(password, BCrypt.gensalt(12)));
        }

    }
}
