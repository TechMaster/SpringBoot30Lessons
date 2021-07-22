package vn.techmaster.personmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
//Tao lop Job
public class Job {
    private int id;
    @NotBlank(message = "Job required")
    private String name;
}
