package com.heaven.usermanagement.repository;

import com.heaven.usermanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepostiory extends JpaRepository<User,Long> {
}
