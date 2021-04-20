package com.tyr.soap.endpoint;

import com.tyr.soap.domain.generated.*;
import com.tyr.soap.exception.CustomException;
import com.tyr.soap.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class SoapServiceEndpoint {

    private static final String NAMESPACE_URI = "http://www.springSoapExample.com/springsoap/usercreation";

    @Autowired
    private ServiceLayer soapService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "searchUserRequest")
    @ResponsePayload
    public SearchUserResponse getCountry(@RequestPayload SearchUserRequest request) {

           return  soapService.searchUser(request.getRut());
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "saveUserRequest")
    @ResponsePayload
    public SaveUserResponse saveUserRequest(@RequestPayload SaveUserRequest request)throws CustomException {
          return     soapService.saveNewUser(request);

    }


}