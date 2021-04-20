package com.tyr.soap.application.service;

import com.tyr.soap.application.domain.User;
import com.tyr.soap.application.domain.generated.SavesUserResponse;
import com.tyr.soap.application.domain.generated.SearchUserResponse;
import java.util.Optional;

public interface BffService {
    public Optional<SearchUserResponse> searchUserService(String rut);
    public Optional<SavesUserResponse> saveUserService(User user);
}
