package com.tyr.soap.application.service.impl;


import com.tyr.soap.application.domain.User;
import com.tyr.soap.application.domain.generated.SaveUserRequest;
import com.tyr.soap.application.domain.generated.SavesUserResponse;
import com.tyr.soap.application.domain.generated.SearchUserRequest;
import com.tyr.soap.application.domain.generated.SearchUserResponse;
import com.tyr.soap.application.persistence.repository.BffSoapServiceCache;
import com.tyr.soap.application.service.BffService;
import com.tyr.soap.application.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import java.util.Optional;

@Service
public class ServiceImpl implements BffService {
    private static final  Logger LOGGER = LoggerFactory.getLogger(ServiceImpl.class);

    @Value("${service.soapServiceUrl}")
    private String clientUrl;

    @Autowired
    private RedisService redisService;

    @Autowired
    private BffSoapServiceCache bffSoapServiceCache;

    @Autowired
    private WebServiceTemplate template;

    @Override
    public Optional<SearchUserResponse> searchUserService(String rut) {

        LOGGER.info("searching the information for rut ,{}",rut);
        SearchUserRequest searchUserRequest = new SearchUserRequest();
        searchUserRequest.setRut(rut);

        Optional<SearchUserResponse> optionalResponse = Optional.empty();
        //Optional<User> user = redisService.searchUserOnRedis("User:"+rut);

        SearchUserResponse user =bffSoapServiceCache.get(rut);
        if( user != null) {
            LOGGER.info("getting value from redis for rut {} and value {}", rut, user.toString());

            optionalResponse =Optional.of(user);
            return optionalResponse;
        }
        try {

            optionalResponse =Optional.of( (SearchUserResponse) template.marshalSendAndReceive(clientUrl, searchUserRequest) );
            LOGGER.info("save on redis the User search ");

            bffSoapServiceCache.set(rut,optionalResponse.get());

        }catch (Exception e){
          LOGGER.error("There is a problem search the rut information {}" +e.getMessage());
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
