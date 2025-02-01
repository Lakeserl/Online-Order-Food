package com.FoorOrdering.Controller;

import com.FoorOrdering.repository.UserRespository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private UserRespository userRespository;

    private PasswordEncoder passwordEncoder;


}
