package com.FoorOrdering.response;

import com.FoorOrdering.model.USER_ROLES;
import lombok.Data;

@Data
public class AuthResponse {
    private String jwt;
    private String message;

    private USER_ROLES roles;

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public USER_ROLES getRoles() {
        return roles;
    }

    public void setRoles(USER_ROLES roles) {
        this.roles = roles;
    }
}
