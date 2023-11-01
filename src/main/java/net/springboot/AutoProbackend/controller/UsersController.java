package net.springboot.AutoProbackend.controller;

import net.springboot.AutoProbackend.exception.ResourceNotFoundException;
import net.springboot.AutoProbackend.model.Users;
import net.springboot.AutoProbackend.repository.UserRepository;
import org.apache.catalina.User;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = {"http://localhost:3000", "https://autoprocare.netlify.app"})
public class UsersController {

    @Autowired
    private UserRepository userRepo;
    @GetMapping
    public List<Users> getAllUsers(){
        return userRepo.findAll();
    }



    //Create user
    @PostMapping
    public Users createUsers(@RequestBody Users user){
        return userRepo.save(user);
    }


    //Get user by id
    @PostMapping("/login")
    public ResponseEntity<Users> getUserByEmailAndPassword(@RequestBody Users user) {
        String email = user.getEmail();
        String password = user.getPassword();

        Users foundUser = userRepo.findByEmailAndPassword(email, password);
        if (foundUser == null) {
            throw new ResourceNotFoundException("User not found with the provided email and password");
        }

        return ResponseEntity.ok(foundUser);
    }


    //Get user by id
    @GetMapping("{id}")
    public ResponseEntity<Users> getUsersById(@PathVariable long id){
        Users user=userRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(("User doesn't exist with id: "+id)));

        return  ResponseEntity.ok(user);
    }

    //build update user
    @PutMapping("{id}")
    public ResponseEntity<Users> updateUser(@PathVariable long id,@RequestBody Users usersGet){
        Users user=userRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(("User doesn't exist with id: "+id)));

        user.setFullName(usersGet.getFullName());
        user.setPhone(usersGet.getPhone());
        user.setStreet(usersGet.getStreet());
        user.setCountry(usersGet.getCountry());
        user.setCity(usersGet.getCity());
        user.setState(usersGet.getState());
        user.setZip(usersGet.getZip());
        user.setBrand(usersGet.getBrand());
        user.setModel(usersGet.getModel());
        user.setYom(usersGet.getYom());
        user.setFuel(usersGet.getFuel());
        user.setTransmission(usersGet.getTransmission());
        user.setMileage(usersGet.getMileage());


        userRepo.save(user);
        return  ResponseEntity.ok(user);
    }

    //build delete user
    @DeleteMapping("{id}")
    public ResponseEntity<Users> deleteUser(@PathVariable long id){
        Users user=userRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(("User doesn't exist with id: "+id)));
        userRepo.delete(user);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
