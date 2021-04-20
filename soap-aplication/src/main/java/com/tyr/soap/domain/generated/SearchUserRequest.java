package com.tyr.soap.domain.generated;


import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "rut"
})
@XmlRootElement(name = "searchUserRequest")
public class SearchUserRequest {

    @XmlElement(required = true)
    private String rut;

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }
}
