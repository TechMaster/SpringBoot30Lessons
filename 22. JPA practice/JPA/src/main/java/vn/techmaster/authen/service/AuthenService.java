package vn.techmaster.authen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.authen.model.Event;
import vn.techmaster.authen.model.Role;
import vn.techmaster.authen.model.User;
import vn.techmaster.authen.repository.EventRepository;
import vn.techmaster.authen.repository.RoleRepository;
import vn.techmaster.authen.repository.UserRepository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AuthenService implements IAuthenService{
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private EventRepository eventRepo;

    @Override
    public User login(String email) {

        return userRepo.findByEmail(email);
    }

    @Override
    public Optional<User> findByUserId(Integer id){
        return userRepo.findById(id);
    }

    @Override
    public Optional<Role> findByRoleId(Integer id) {
        return roleRepo.findById(id);
    }

    @Override
    public void createAccount(User user) {
        userRepo.save(user);
    }

    @Override
    public void setDefault() {
        User user = userRepo.findById(1).get();
        user.addRole(roleRepo.findById(1).get());
        userRepo.deleteById(1);
        userRepo.save(user);
    }

    @Override
    public void updateAccount(User user) {
        User exist = userRepo.findById(user.getId()).get();
        if(exist!=null){
            exist.setFullname(user.getFullname());
            exist.setEmail(user.getEmail());
            userRepo.save(exist);
        }

    }

    @Override
    public void updatePassword(User user) {
        User exist = userRepo.findById(user.getId()).get();
        if(exist!=null){
            exist.setPassword(user.getPassword());
            userRepo.save(exist);
        }

    }

    @Override
    public void updateRole(User user) {
        User exist = userRepo.findById(user.getId()).get();
        if(exist!=null){
            exist.setRoles(user.getRoles());
            userRepo.save(exist);
        }
    }


    @Override
    public List<Role> listRole() {
        return roleRepo.findAll();
    }


    @Override
    public Set<Role> getRoles(User user) {
        return user.getRoles();
    }

//    @Override
//    public void logout() {
//
//    }

    @Override
    public boolean isAdmin(Integer userID) {
        User user = userRepo.findById(userID).get();
        Set<Role> roles = getRoles(user);
        for(Role role:roles){
            if(role.getName().equals("admin"))
                return true;
        }
        return false;
    }


}
