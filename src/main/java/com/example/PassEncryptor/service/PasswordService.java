package com.example.PassEncryptor.service;

import com.example.PassEncryptor.model.Credential;
import com.example.PassEncryptor.util.CryptUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PasswordService {
    private final Map<String , Credential> credentialStore = new HashMap<>();

    public void saveCredential(String username , String service , String password ) {
        String encrypted = CryptUtil.encrypt(password);
        Credential cred = new Credential(username , service , encrypted);
        credentialStore.put(username + ":" + service , cred);
    }

    public  String getPassword(String username , String service ) {
        Credential cred = credentialStore.get( username + ":" + service);
        if(cred != null) {
            return CryptUtil.decrypt(cred.getEncryptedPassword());
        }
        return null;
    }

    public List<Credential> getALlCredential() {
        return new ArrayList<>(credentialStore.values());

    }
}
