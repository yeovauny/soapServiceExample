package com.tyr.soap.domain.model;


import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name="User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @NotNull
    @Column(name="ID")
    private Long userId;

    @Column(name="NAME")
    protected String name;

    @Column(name="LAST_NAME")
    protected String apellido;

    @Column(name="RUT")
    protected String rut;

    @Column(name="ACTIVE")
    protected boolean activo;

    @Column(name="IDENTITY")
    protected int id;

    public Long getUserId() {
        return userId;
    }


    public void setUserId(Long userId) {
        this.userId = userId;
    }

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




    public User withName(String name){
        this.name = name;
        return this;  //By returning the builder each time, we can create a fluent interface.
    }

    public User withLastmane(String lastmane){
        this.apellido = lastmane;
        return this;
    }

    public User withId(int id){
        this.id = id;
        return this;
    }

    public User isActive(boolean active){
        this.activo = active;
        return this;
    }

    public User withRut(String rut){
        this.rut=rut;
        return this;
    }


    public User build(){
        User user = new User();
        user.id = this.id;
        user.activo = this.activo;
        user.name = this.name;
        user.apellido= this.apellido;
        user.rut= this.rut;
        return user;
    }


}
