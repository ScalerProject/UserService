package com.scaler.userservicejan25.services;

import com.scaler.userservicejan25.models.Token;
import com.scaler.userservicejan25.models.User;

public interface UserService {
    User signup(String email, String password, String name);
    Token login(String email, String password);
    void logout(String tokenValue);
    User validateToken(String tokenValue);
}
