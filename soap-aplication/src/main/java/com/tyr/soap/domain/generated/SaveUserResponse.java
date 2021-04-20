package com.tyr.soap.domain.generated;


import javax.xml.bind.annotation.*;
import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "message",
        "fecha"
})
@XmlRootElement(name = "savesUserResponse")
public class SaveUserResponse {

    @XmlElement(required = true)
    protected String message;

    @XmlElement(required = true)
    protected Date fecha;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }



}
