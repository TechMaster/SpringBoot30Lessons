package com.heaven.authentication.controller;

import com.heaven.authentication.dto.UserDto;
import com.heaven.authentication.entity.User;
import com.heaven.authentication.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserRepository userRepo;
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody User user){
        if(user.getPassword().length()<8 || !user.getPassword().equals(user.getConfirmPassword())){
            return ResponseEntity.badRequest().build();
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        UserDto userDto = new UserDto(user.getId(),user.getUsername());

        return ResponseEntity.ok(userDto);
    }
    @GetMapping("/{username}")
    public ResponseEntity<?> getUser(@PathVariable("username") String username){
        User user = userRepo.findByUsername(username);
        if(user!=null){
            UserDto userDto = new UserDto(user.getId(),user.getUsername());
            return ResponseEntity.ok(userDto);
        }
        return ResponseEntity.notFound().build();
    }
}
