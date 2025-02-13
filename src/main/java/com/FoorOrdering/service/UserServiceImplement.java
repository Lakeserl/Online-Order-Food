package com.FoorOrdering.service;

import com.FoorOrdering.config.JwtProvider;
import com.FoorOrdering.model.User;
import com.FoorOrdering.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class  UserServiceImplement implements UserService {

    @Autowired
    private UserRespository userRespository;

    @Autowired
    private JwtProvider jwtProvider;
    @Override
    public User findUserByJwtToken(String jwt) throws Exception {
        String email = jwtProvider.getEmailFromJwtToken(jwt);
        User user = findUserByEmail(email);

        return user;
    }

    @Override
    public User findUserByEmail(String email) throws Exception {
        User user = userRespository.findByEmail(email);

        if(user==null){
            throw new Exception("User not found");
        }
        return user;
    }
}
