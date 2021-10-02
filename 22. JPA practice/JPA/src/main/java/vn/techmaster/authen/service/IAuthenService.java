package vn.techmaster.authen.service;

import vn.techmaster.authen.model.Role;
import vn.techmaster.authen.model.User;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IAuthenService {
    User login(String email);
    Optional<User> findByUserId(Integer id);
    Optional<Role> findByRoleId(Integer id);
    void createAccount(User user);
    void setDefault();
    void updateAccount(User user);
    void updatePassword(User user);
    void updateRole(User user);
    List<Role> listRole();
    Set<Role> getRoles(User user);
    void logout();
    boolean isAdmin(Integer userId);
}
