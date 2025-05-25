package com.vinay.studentenrollment;

import com.vinay.studentenrollment.models.User;
import com.vinay.studentenrollment.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class StudentCourseEnrollmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentCourseEnrollmentApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			if (!userRepository.existsByUsername("admin")) {
				User admin = new User();
				admin.setUsername("admin");
				admin.setPassword(passwordEncoder.encode("admin123"));
				admin.setRole("ADMIN");
				userRepository.save(admin);
				System.out.println("Admin user created: admin / admin123");
			}

			if (!userRepository.existsByUsername("student")) {
				User student = new User();
				student.setUsername("student");
				student.setPassword(passwordEncoder.encode("student123"));
				student.setRole("STUDENT");
				userRepository.save(student);
				System.out.println("Student user created: student / student123");
			}
		};
	}
}
