package com.tyr.soap.application.persistence.repository;

import com.tyr.soap.application.domain.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends CrudRepository<User, String> {
}
