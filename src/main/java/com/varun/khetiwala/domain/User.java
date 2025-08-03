package com.varun.khetiwala.domain;

import com.varun.khetiwala.helper.JsonCommand;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@Entity
@Table(name = "m_users")
public class User extends AbstractPersistableCustom {

    @Column(name = "user_name", nullable = false)
    private String username;

    @Column(unique = true, length = 100)
    private String email;

    @Column(name = "mobile_number", unique = true, length = 15)
    private String mobileNumber;

    @Column(length = 255)
    private String password;

    @Column(name = "profile_pic", length = 255)
    private String profilePic;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "role", nullable = false)
    private Integer role;

    public User(String username, String email, String mobileNumber, String password, String profilePic, LocalDateTime createdAt, Integer role) {
        this.username = username;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.password = password;
        this.profilePic = profilePic;
        this.createdAt = createdAt;
        this.role = role;
    }
    public Map<String, Object> update(final JsonCommand command) {
        final Map<String, Object> actualChanges = new LinkedHashMap<>();

        if (command.isChangeInStringParameterNamed("userName", this.username)) {
            final String newValue = command.stringValueOfParameterNamed("userName");
            actualChanges.put("userName", newValue);
            this.username = newValue;
        }

        if (command.isChangeInStringParameterNamed("email", this.email)) {
            final String newValue = command.stringValueOfParameterNamed("email");
            actualChanges.put("email", newValue);
            this.email = newValue;
        }

        if (command.isChangeInStringParameterNamed("mobileNumber", this.mobileNumber)) {
            final String newValue = command.stringValueOfParameterNamed("mobileNumber");
            actualChanges.put("mobileNumber", newValue);
            this.mobileNumber = newValue;
        }

        if (command.isChangeInStringParameterNamed("profilePic", this.profilePic)) {
            final String newValue = command.stringValueOfParameterNamed("profilePic");
            actualChanges.put("profilePic", newValue);
            this.profilePic = newValue;
        }

        if (command.isChangeInStringParameterNamed("password", this.password)) {
            final String newValue = command.stringValueOfParameterNamed("password");
            actualChanges.put("password", newValue);
            this.password = newValue;
        }
        return actualChanges;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }


}

