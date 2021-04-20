package com.tyr.soap.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.endpoint.interceptor.EndpointInterceptorAdapter;
import org.springframework.ws.soap.saaj.SaajSoapMessage;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

@Configuration
public class CustomEndpointInterceptor extends EndpointInterceptorAdapter {

    private static final String DEFAULT_NS = "xmlns:SOAP-ENV";
    private static final String SOAP_ENV_NAMESPACE = "http://www.springSoapExample.com/springsoap/usercreation";
    private static final String PREFERRED_PREFIX = "soapenv";
    private static final String HEADER_LOCAL_NAME = "Header";
    private static final String BODY_LOCAL_NAME = "Body";
    private static final String FAULT_LOCAL_NAME = "Fault";

    @Override
    public boolean handleResponse(MessageContext messageContext, Object endpoint) throws Exception {
        SaajSoapMessage soapResponse = (SaajSoapMessage) messageContext.getResponse();
        alterSoapEnvelope(soapResponse);
        return super.handleResponse(messageContext, endpoint);
    }

    @Override
    public boolean handleFault(MessageContext messageContext, Object endpoint) throws Exception {
        SaajSoapMessage soapResponse = (SaajSoapMessage) messageContext.getResponse();
        alterSoapEnvelope(soapResponse);
        return super.handleFault(messageContext, endpoint);
    }

    private void alterSoapEnvelope(SaajSoapMessage soapResponse) {
        Document doc = soapResponse.getDocument();
        Element rootElement = doc.getDocumentElement();
        rootElement.setPrefix(PREFERRED_PREFIX);
        // Remove default SOAP namespace
        rootElement.removeAttribute(DEFAULT_NS);
        NodeList headerNodes = doc.getElementsByTagNameNS(SOAP_ENV_NAMESPACE, HEADER_LOCAL_NAME);
        NodeList bodyNodes = doc.getElementsByTagNameNS(SOAP_ENV_NAMESPACE, BODY_LOCAL_NAME);
        NodeList faultNodes = doc.getElementsByTagNameNS(SOAP_ENV_NAMESPACE, FAULT_LOCAL_NAME);
        // Remove Header node.
        if (headerNodes.getLength() != 0) {
            rootElement.removeChild(headerNodes.item(0));
        }
        // Change Body's SOAP namespace prefix.
        if (bodyNodes.getLength() != 0) {
            Element bodyElement = (Element) bodyNodes.item(0);
            bodyElement.setPrefix(PREFERRED_PREFIX);
        }
        if (faultNodes.getLength() != 0) {
            Element faultElement = (Element) faultNodes.item(0);
            faultElement.setPrefix(PREFERRED_PREFIX);
        }
    }


}
