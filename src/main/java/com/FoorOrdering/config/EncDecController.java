package com.FoorOrdering.config;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


@RestController
public class EncDecController {
//    @Autowired
//    private EncryptionService encryptionService;
//    @PostMapping("/enc")
//    public String encrypt(@RequestBody String data) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
//        return   encryptionService.encrypt(data);
//    }
//
//    @PostMapping("/dec")
//    public String decrypt(@RequestBody String encryptedData) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
//        return   encryptionService.decrypt(encryptedData);
//    }
}
