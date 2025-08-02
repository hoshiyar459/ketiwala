package com.varun.khetiwala.api;


import com.varun.khetiwala.domain.RoleEnum;
import com.varun.khetiwala.helper.EnumOptionData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/khetiwala/user")
public class UserApiResource {

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
}
