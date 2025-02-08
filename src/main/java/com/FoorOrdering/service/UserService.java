package com.FoorOrdering.service;

import com.FoorOrdering.model.User;

import java.util.concurrent.ExecutionException;

public interface UserService {

    public User findUserByJwtToken(String jwt) throws Exception;

    public User findUserByEmail(String email) throws Exception;
}
