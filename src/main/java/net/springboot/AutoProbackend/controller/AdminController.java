package net.springboot.AutoProbackend.controller;


import net.springboot.AutoProbackend.exception.ResourceNotFoundException;
import net.springboot.AutoProbackend.model.Admin;
import net.springboot.AutoProbackend.model.Users;
import net.springboot.AutoProbackend.repository.AdminRepository;
import net.springboot.AutoProbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@CrossOrigin(origins = {"http://localhost:3000", "https://autoprocare.netlify.app"})

public class AdminController {


    @Autowired
    private AdminRepository adminRepo;
    @GetMapping
    public List<Admin> getAllAdmin(){
        return adminRepo.findAll();
    }



    @PostMapping
    public Admin createAdmin(@RequestBody Admin admin){
        return adminRepo.save(admin);
    }

    @PostMapping("/login")
    public ResponseEntity<Admin> getAdminByUserNameAndPassword(@RequestBody Admin admin) {
        String username = admin.getUsername();
        String password = admin.getPassword();

        Admin foundAdmin =adminRepo.findByUsernameAndPassword(username, password);
        if (foundAdmin == null) {
            throw new ResourceNotFoundException("Admin not found with the provided username and password");
        }

        return ResponseEntity.ok(foundAdmin);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Admin> deleteAdmin(@PathVariable long id){
        Admin admin=adminRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(("User doesn't exist with id: "+id)));
        adminRepo.delete(admin);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
