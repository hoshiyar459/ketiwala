package com.varun.khetiwala.api;


import com.varun.khetiwala.domain.RoleEnum;
import com.varun.khetiwala.domain.User;
import com.varun.khetiwala.exception.PlatformDataIntegrityException;
import com.varun.khetiwala.helper.EnumOptionData;
import com.varun.khetiwala.service.UserWritePlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/khetiwala/user")
public class UserApiResource {

  private final UserWritePlatformService userWritePlatformService;

  @Autowired
    public UserApiResource(UserWritePlatformService userWritePlatformService) {
        this.userWritePlatformService = userWritePlatformService;
    }

    @GetMapping("/template")
    public ResponseEntity<List<EnumOptionData>> getAllRoles() {
        List<EnumOptionData> roles = Arrays.stream(RoleEnum.values())
                .map(role -> new EnumOptionData(
                        role.getId().longValue(),
                        role.getValue(),
                        role.getCode()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(roles);
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        try {
            User newUser = userWritePlatformService.createUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
        } catch (PlatformDataIntegrityException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create user: " + ex.getMessage());
        }
    }


}
