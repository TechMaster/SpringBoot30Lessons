package vn.techmaster.authen;

import org.apache.commons.lang3.RandomStringUtils;
import org.mindrot.jbcrypt.BCrypt;



public class PasswordGenerator {

    public static void main(String[] args) {
        String password ="admin";

        String hash = BCrypt.hashpw(password,BCrypt.gensalt(12));
        System.out.println("Bcryt hash: " + hash);
        boolean valid = BCrypt.checkpw(password,"$2a$12$Ass3YFsOBQ.36vmAqUsGPucTiSQC35mKqiYb2ibg3yHHLxj.rJP2q");
        System.out.println(valid);
        String generatedString = RandomStringUtils.randomAlphabetic(10);

        System.out.println(generatedString);
    }
}
