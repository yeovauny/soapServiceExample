package com.tyr.soap.domain.generated;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "name",
        "apellido",
        "rut",
        "activo",
        "id"
})
@XmlRootElement(name = "searchUserResponse")
public class SearchUserResponse {

    @XmlElement(required = true)
    protected String name;

    @XmlElement(required = true)
    protected String apellido;

    @XmlElement(required = true)
    protected String rut;

    @XmlElement(required = true)
    protected boolean activo;

    @XmlElement(required = true)
    protected int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SearchUserResponse withName(String name){
        this.name= name;
        return this;
    }
    public SearchUserResponse withLastName(String lastName){
        apellido= lastName;
        return this;
    }
    public SearchUserResponse isActive(boolean active){
        activo = active;
        return this;
    }
    public SearchUserResponse withRut(String rut){
        this.rut=rut;
        return this;
    }
    public SearchUserResponse andId(int id){
        this.id= id;
        return this;
    }


    public SearchUserResponse build(){
        SearchUserResponse searchUserResponse= new SearchUserResponse();
        searchUserResponse.id=this.id;
        searchUserResponse.name= this.name;
        searchUserResponse.apellido= this.apellido;
        searchUserResponse.rut= this.rut;
        searchUserResponse.activo= this.activo;
        return searchUserResponse;
    }


}
