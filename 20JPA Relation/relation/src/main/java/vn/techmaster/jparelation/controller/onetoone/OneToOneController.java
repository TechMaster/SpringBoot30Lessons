package vn.techmaster.jparelation.controller.onetoone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.techmaster.jparelation.model.onetoone.User;
import vn.techmaster.jparelation.service.onetoone.UserService;

import java.util.List;

@RestController
public class OneToOneController {
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(userService.getAll());
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> queryAllUsers() {
        return ResponseEntity.ok().body(userService.queryAll());
    }
}
