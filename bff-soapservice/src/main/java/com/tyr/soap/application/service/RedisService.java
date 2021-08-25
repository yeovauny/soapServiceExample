package com.tyr.soap.application.service;

import com.tyr.soap.application.domain.User;
import com.tyr.soap.application.domain.generated.SearchUserResponse;
import com.tyr.soap.application.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

@Service
public class RedisService {

    @Autowired
    UserRepository userRepository;

    public void saveUserOnRedis(SearchUserResponse searchUserResponse){

        User user = new User();
        user.setApellido(searchUserResponse.getApellido());
        user.setName(searchUserResponse.getName());
        user.setId(searchUserResponse.getId());
        user.setRut(searchUserResponse.getRut());
        user.setActivo(true);
        userRepository.save(user);
    }

    public Optional<User> searchUserOnRedis(String rut){

        return userRepository.findById(rut);
       // return null;
    }
}
