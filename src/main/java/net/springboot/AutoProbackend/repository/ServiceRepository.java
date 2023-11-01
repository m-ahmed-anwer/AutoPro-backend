package net.springboot.AutoProbackend.repository;

import net.springboot.AutoProbackend.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, Long> {
    List<Service> findByUid(int uid);
}
