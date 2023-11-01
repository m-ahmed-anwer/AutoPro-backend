package net.springboot.AutoProbackend.repository;

import net.springboot.AutoProbackend.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository  extends JpaRepository<Admin,Long> {
    Admin findByUsernameAndPassword(String username, String password);
}
