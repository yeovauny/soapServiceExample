package com.tyr.soap.application.endpoint;

import com.tyr.soap.application.domain.User;
import com.tyr.soap.application.domain.generated.SavesUserResponse;
import com.tyr.soap.application.domain.generated.SearchUserResponse;
import com.tyr.soap.application.service.BffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api")
public class EndPointResources {


    @Autowired
    BffService serviceImpl;

    @GetMapping("search")
    //@Cacheable(value = "users",key = "#rut")
    public ResponseEntity<SearchUserResponse> searchUser(@RequestParam Optional<String> rut){

        return serviceImpl.searchUserService(rut.get()).map(
                user -> new ResponseEntity<>(user, HttpStatus.OK)
        ).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("savenewuser")
    public ResponseEntity<SavesUserResponse> savenewUser(@RequestBody User user){

      return  serviceImpl.saveUserService(user).map( created ->
                new ResponseEntity<>(created,HttpStatus.OK)
                ).orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));


    }



}
