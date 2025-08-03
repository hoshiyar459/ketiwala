package com.varun.khetiwala.service;

import com.varun.khetiwala.data.UpdateUserRequest;
import com.varun.khetiwala.domain.User;

import java.util.Map;

public interface UserWritePlatformService {

    public User createUser(User user);
    public Map<String, Object> updateUser(Long id, UpdateUserRequest request);
    public void deleteUser(Long Id);
}
