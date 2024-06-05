package com._frames.version_control_system.dao;

import com._frames.version_control_system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
