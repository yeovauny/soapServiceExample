package com.tyr.soap.repository;

import com.tyr.soap.domain.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository  extends CrudRepository<User, Long> {

    public Optional<User> findUserByRutAndName(String rut, String name);

    public Optional<User> findByRut(String rut);
}
