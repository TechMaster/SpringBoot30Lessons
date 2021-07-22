package vn.techmaster.personmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private int id;
    @NotBlank(message = "your name is required")
    @Size(min = 5, max = 30, message = "Name must between 5 and 30")
    private String name;
    @NotBlank(message = "your job is required")
    private String job;
    private boolean gender;
    @NotBlank(message = "your birthday is required")
    private String birthDay;
    private MultipartFile photo;
}
