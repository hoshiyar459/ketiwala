package com.varun.khetiwala.service;

import com.varun.khetiwala.domain.User;

public interface UserWritePlatformService {

    public User createUser(User user);
    public User updateUser(User user);
    public void deleteUser(Long Id);
}
