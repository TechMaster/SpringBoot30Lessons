package vn.techmaster.demoupload.config;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import vn.techmaster.demoupload.localization.DBMessageSource;

@Configuration
public class LanguageConfig implements WebMvcConfigurer {
 // @Autowired private MessageSource messageSource;

  //Xác định ngôn ngữ người dùng chọn qua Cookie
  @Bean public LocaleResolver localeResolver() {
    CookieLocaleResolver localeResolver = new CookieLocaleResolver();
    localeResolver.setDefaultLocale(Locale.US);
    return localeResolver;
  }

  @Bean public MessageSource messageSource() {
    return new DBMessageSource();
  }

  //Đọc lựa chọn ngôn ngữ người dùng muốn chuyển sang qua tham số lang
  @Bean public LocaleChangeInterceptor localeChangeInterceptor() {
    LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
    // Defaults to "locale" if not set
    localeChangeInterceptor.setParamName("lang");
    return localeChangeInterceptor;
  }

  //Bổ xung localeChangeInterceptor vào danh sách intercepter xử lý request gửi lên
  @Override
  public void addInterceptors(InterceptorRegistry interceptorRegistry) {
    interceptorRegistry.addInterceptor(localeChangeInterceptor());
  }

  //Hỗ trợ đa ngôn ngữ các thông điệp báo lỗi trong Hibernate Validator
  @Bean public LocalValidatorFactoryBean validator(MessageSource messageSource) {
      LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
      bean.setValidationMessageSource(messageSource);      
      return bean;
  }
}