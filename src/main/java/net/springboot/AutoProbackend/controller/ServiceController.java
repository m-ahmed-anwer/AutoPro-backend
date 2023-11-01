package net.springboot.AutoProbackend.controller;


import net.springboot.AutoProbackend.exception.ResourceNotFoundException;
import net.springboot.AutoProbackend.model.Service;
import net.springboot.AutoProbackend.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/service")
@CrossOrigin(origins = {"http://localhost:3000", "https://autoprocare.netlify.app"})

public class ServiceController {


    @Autowired
    private ServiceRepository serviceRepo;

    @GetMapping
    public List<Service> getAllServices() {
        return serviceRepo.findAll();
    }


    @PostMapping
    public Service createService(@RequestBody Service service) {
        return serviceRepo.save(service);
    }

    @GetMapping("/uid/{uid}")
    public List<Service> getServicesByUid(@PathVariable int uid) {
        List<Service> services = serviceRepo.findByUid(uid);

        if (services.isEmpty()) {
            throw new ResourceNotFoundException("No services found for uid: " + uid);
        }

        return services;
    }

    @PutMapping("/status/{id}")
    public ResponseEntity<Service> updateServiceStatus(@PathVariable long id) {
        Service service = serviceRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Service doesn't exist with id: " + id));

        service.setStatus(false);

        serviceRepo.save(service);

        return ResponseEntity.ok(service);
    }



    //Get Service by id
    @GetMapping("{id}")
    public ResponseEntity<Service> getServiceById(@PathVariable long id){
        Service service=serviceRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(("Service doesn't exist with id: "+id)));

        return  ResponseEntity.ok(service);
    }



    @DeleteMapping("{id}")
    public ResponseEntity<Service> deleteService(@PathVariable long id){
        Service service=serviceRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(("Service doesn't exist with id: "+id)));
        serviceRepo.delete(service);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
