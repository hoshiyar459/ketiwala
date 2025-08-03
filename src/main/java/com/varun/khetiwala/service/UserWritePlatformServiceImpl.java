package com.varun.khetiwala.service;

import com.varun.khetiwala.domain.RoleEnum;
import com.varun.khetiwala.domain.User;
import com.varun.khetiwala.exception.PlatformDataIntegrityException;
import com.varun.khetiwala.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserWritePlatformServiceImpl implements UserWritePlatformService{


    private final UserRepository userRepository ;

    @Autowired
    public UserWritePlatformServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        try {
            if (user == null) {
                throw new PlatformDataIntegrityException("error.msg.user.invalid.payload", "User payload cannot be null");
            }
            if (user.getEmail() != null && userRepository.existsByEmail(user.getEmail())) {
                throw new PlatformDataIntegrityException("error.msg.user.email.already.exists", "Email already in use");
            }
            if (user.getMobileNumber() != null && userRepository.existsByMobileNumber(user.getMobileNumber())) {
                throw new PlatformDataIntegrityException("error.msg.user.phone.number.already.exists", "Mobile number already in use");
            }

            return userRepository.save(user);
        } catch (PlatformDataIntegrityException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new PlatformDataIntegrityException("error.msg.user.creation.failed", "Failed to create user. Reason: " + ex.getMessage());
        }
    }


    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(Long Id) {

    }
}
