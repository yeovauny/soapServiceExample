package com.tyr.soap.application.service.impl;


import com.tyr.soap.application.domain.User;
import com.tyr.soap.application.domain.generated.SaveUserRequest;
import com.tyr.soap.application.domain.generated.SavesUserResponse;
import com.tyr.soap.application.domain.generated.SearchUserRequest;
import com.tyr.soap.application.domain.generated.SearchUserResponse;
import com.tyr.soap.application.service.BffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import java.util.Optional;

@Service
public class ServiceImpl implements BffService {


    @Value("${service.soapServiceUrl}")
    private String clientUrl;

   // @Autowired
   // private Jaxb2Marshaller jaxb2Marshaller;

    @Autowired
    private WebServiceTemplate template;

    @Override
    public Optional<SearchUserResponse> searchUserService(String rut) {
        SearchUserRequest searchUserRequest = new SearchUserRequest();
        searchUserRequest.setRut(rut);

        Optional<SearchUserResponse> optionalResponse = Optional.empty();

        try {
            optionalResponse =Optional.of( (SearchUserResponse) template.marshalSendAndReceive(clientUrl, searchUserRequest) );
        }catch (Exception e){
            e.printStackTrace();
        }
      return optionalResponse;
    }

    @Override
    public Optional<SavesUserResponse> saveUserService(User user) {
        Optional<SavesUserResponse> optionalResponse = Optional.empty();
        SaveUserRequest saveUserRequest = new SaveUserRequest();
        saveUserRequest.setRut(user.getRut());
        saveUserRequest.setActivo(user.isActivo());
        saveUserRequest.setApellido(user.getApellido());
        saveUserRequest.setId(user.getId());
        saveUserRequest.setName(user.getName());
        try {
            optionalResponse =Optional.of( (SavesUserResponse) template.marshalSendAndReceive(clientUrl, saveUserRequest) );
        }catch (Exception e){
            e.printStackTrace();
        }
        return optionalResponse;

    }
}
