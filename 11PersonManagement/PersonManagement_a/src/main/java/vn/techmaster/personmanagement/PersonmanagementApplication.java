package vn.techmaster.personmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class PersonmanagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonmanagementApplication.class, args);
    }


    @Configuration
    public class WebConfig implements WebMvcConfigurer{
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/photos/**").addResourceLocations("file:photos/");
        }
    }
}
