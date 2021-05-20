package com.nabla.careermanagement;


import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import com.nabla.careermanagement.spring.security.model.User;
import com.nabla.careermanagement.spring.security.repo.UserRepository;

@SpringBootApplication
public class CareerManagementServiceApplication implements  CommandLineRunner  {

    @Autowired
    UserRepository userRepository;

    Random random = new Random();

    public void createUsers() {


        User user = new User();
        Long id = new Long(random.nextInt(100));
        user.setId(id);
        user.setEmail("user" + id + "@gmail.com");
        user.setPassword("user" + id);
        
        user.setRol("Admin");
        user.setUsername("user" + id);
        User save = this.userRepository.save(user);

        System.out.println(save);


    }
   

    public static void main(String[] args) {
        SpringApplication.run(CareerManagementServiceApplication.class, args);

    }


    @Override
    public void run(String... args) throws Exception {
        createUsers();
    }
}










