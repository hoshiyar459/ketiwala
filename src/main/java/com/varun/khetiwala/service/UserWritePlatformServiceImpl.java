package com.varun.khetiwala.service;

import com.varun.khetiwala.domain.RoleEnum;
import com.varun.khetiwala.domain.User;
import com.varun.khetiwala.exception.PlatformDataIntegrityException;
import com.varun.khetiwala.helper.JsonCommand;
import com.varun.khetiwala.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

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
    public Map<String, Object> updateUser(Long id, JsonCommand command) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Map<String, Object> changes = user.update(command);

        if (!changes.isEmpty()) {
            userRepository.save(user);
        }
        return changes;
    }


    @Override
    public void deleteUser(Long Id) {

    }
}
