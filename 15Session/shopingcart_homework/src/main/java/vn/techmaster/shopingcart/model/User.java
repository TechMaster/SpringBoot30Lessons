package vn.techmaster.shopingcart.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
//Validate user form
public class User {
    private Long id=1L;
    @Size(min = 5, max = 30, message = "{name_size_between_5_30}")
    private String name;
    @NotBlank(message = "email required")
    @Email
    private String email;
    @NotBlank(message = "mobileNumber is required")
    @Size(min = 10, max = 10)
    private String phone;
    @NotBlank(message = "address required")
    private String address;

    public User(String name, String email, String phone, String address) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.id++;
    }
}
