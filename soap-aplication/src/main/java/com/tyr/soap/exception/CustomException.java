package com.tyr.soap.exception;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.SERVER)
public class CustomException extends Exception {
    private static final long serialVersionUID = -1804604596179996724L;

    private String faultDetail;

    public CustomException(){
        super("Exception handler");
    }

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomException(String message, Throwable cause, String fautDetail) {
        super(message, cause);
        setFaultDetail( fautDetail );
    }

    public String getFaultDetail() {
        return faultDetail;
    }

    public void setFaultDetail(String faultDetail) {
        this.faultDetail = faultDetail;
    }
}
