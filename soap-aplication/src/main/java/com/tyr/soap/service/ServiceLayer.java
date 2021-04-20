package com.tyr.soap.service;


import com.tyr.soap.domain.generated.SaveUserRequest;
import com.tyr.soap.domain.generated.SaveUserResponse;
import com.tyr.soap.domain.generated.SearchUserResponse;
import com.tyr.soap.domain.model.User;
import com.tyr.soap.exception.CustomException;
import com.tyr.soap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Optional;

@Service
public class ServiceLayer {

    @Autowired
    UserRepository userRepository;

    public SaveUserResponse saveNewUser(SaveUserRequest saveUser) throws CustomException{

        Optional <User> user = userRepository.findUserByRutAndName(saveUser.getRut(),saveUser.getName());

        if(!user.isPresent()) {
            User user1 = new User()
                    .withName(saveUser.getName())
                    .withLastmane(saveUser.getApellido())
                    .withId(saveUser.getId())
                    .withRut(saveUser.getRut())
                    .isActive(saveUser.isActivo())
                    .build();
            userRepository.save(user1);

            SaveUserResponse saveUserResponse= new SaveUserResponse();
            saveUserResponse.setMessage("the user was created!");
            saveUserResponse.setFecha(new Date());
            return saveUserResponse;

        }else
            throw new CustomException("Este usuario ya existe!");

    }

    public SearchUserResponse searchUser(String rut){
        Optional <User> user = userRepository.findByRut(rut);
        if(user.isPresent()){
            SearchUserResponse searchUserResponse= new SearchUserResponse()
                    .withName(user.get().getName())
                    .withLastName(user.get().getApellido())
                    .withRut(user.get().getRut())
                    .isActive(user.get().isActivo())
                    .andId(user.get().getId())
                    .build();
            return searchUserResponse;
        }
            else
                return null;
    }



}
