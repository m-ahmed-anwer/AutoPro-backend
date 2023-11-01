package net.springboot.AutoProbackend.repository;

import net.springboot.AutoProbackend.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Long> {
    //ALl CRUD Operations are done here
    Users findByEmailAndPassword(String email, String password);

}
