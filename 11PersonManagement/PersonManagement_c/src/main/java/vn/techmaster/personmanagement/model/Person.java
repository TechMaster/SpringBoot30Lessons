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
//Tao lop Person
public class Person {
    private int id;
    //Cac truong can validate
    @Size(min = 5, max = 30, message = "{name_size_between_5_30}")
    private String name;

    @NotBlank(message = "{job.cannot.null}")
    private String job;
    private boolean gender;
    @NotBlank(message = "{birthDay.cannot.null}")
    private String birthDay;
    private MultipartFile photo;
}
