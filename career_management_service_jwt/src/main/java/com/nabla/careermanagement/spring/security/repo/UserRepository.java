package com.nabla.careermanagement.spring.security.repo;



import org.springframework.data.mongodb.repository.MongoRepository;

import com.nabla.careermanagement.spring.security.model.User;

public interface UserRepository extends  MongoRepository<User, Long> {
    //username , it will return the user of given username
    public User findByUsername(String username);
}
