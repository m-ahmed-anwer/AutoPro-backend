package net.springboot.AutoProbackend;


import net.springboot.AutoProbackend.model.Users;
import net.springboot.AutoProbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AutoProBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AutoProBackendApplication.class, args);
	}

	@Autowired
	private UserRepository userRepo;

	@Override
	public void run(String... args) throws Exception {
		Users user = new Users();
		userRepo.save(user);
	}
}
