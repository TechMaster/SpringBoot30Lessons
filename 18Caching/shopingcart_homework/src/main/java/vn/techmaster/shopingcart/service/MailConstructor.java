package vn.techmaster.shopingcart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import vn.techmaster.shopingcart.model.Cart;
import vn.techmaster.shopingcart.model.User;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
public class MailConstructor {
    @Autowired
    private TemplateEngine templateEngine;

    // Cấu hình mail gửi đến khách hàng
    public MimeMessagePreparator constructOrderConfirmationEmail(User user, Cart cart) {
        Context context = new Context();
        context.setVariable("user", user); // attribute user trong mail template
        context.setVariable("cart", cart); // attribute cart trong mail template
        // Email template
        String text = templateEngine.process("orderConfirmationEmailTemplate", context);

        return new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper email = new MimeMessageHelper(mimeMessage);
                // Địa chỉ nhận mail
                email.setTo(user.getEmail());
                // Thông tin tiêu đề mail
                email.setSubject("Order Confirmation -" + user.getName());
                // Nội dung mail
                email.setText(text, true);
                // Thông tin người gửi mail
                email.setFrom(new InternetAddress("quangbookstore1@gmail.com"));
            }
        };
        
    }
}
