package com.varun.khetiwala.service;

import com.varun.khetiwala.domain.User;
import com.varun.khetiwala.helper.JsonCommand;

import java.util.Map;

public interface UserWritePlatformService {

    public User createUser(User user);
    public Map<String, Object> updateUser(Long id, JsonCommand command);
    public void deleteUser(Long Id);
}
