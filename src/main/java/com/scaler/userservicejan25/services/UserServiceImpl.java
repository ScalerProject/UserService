package com.scaler.userservicejan25.services;

import com.scaler.userservicejan25.exceptions.UnauthorizedException;
import com.scaler.userservicejan25.exceptions.UserNotFoundException;
import com.scaler.userservicejan25.models.Token;
import com.scaler.userservicejan25.models.User;
import com.scaler.userservicejan25.repositories.TokenRepository;
import com.scaler.userservicejan25.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;

    public UserServiceImpl(UserRepository userRepository, TokenRepository tokenRepository) {
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
    }

    @Override
    public User signup(String email, String password, String name) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);

        return userRepository.save(user);
    }

    @Override
    public Token login(String email, String password) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if(optionalUser.isEmpty()){
            throw new UserNotFoundException(email, "User not found");
        }
        User user = optionalUser.get();
        if(user.getPassword().equals(password)) {
            Token token = new Token();
            token.setTokenValue("token");

            Date currentDate = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(currentDate);

            //Add 30 days to the calendar to set the token expiry date
            calendar.add(Calendar.DAY_OF_MONTH, 30);

            //Get the updated time as a date object
            Date dateAfter30Days = calendar.getTime();
            token.setExpiryDate(dateAfter30Days);
            return tokenRepository.save(token);
        }

        //if login password is not matching - login failed
        throw new UnauthorizedException("Invalid password");
    }

    @Override
    public void logout(String tokenValue) {
        Optional<Token> optionalToken = tokenRepository.findByTokenValue(tokenValue);
        if(optionalToken.isEmpty()){
            throw new UnauthorizedException("Invalid token");
        }
        Token token = optionalToken.get();
        token.setDeleted(true);
        tokenRepository.save(token);
    }

    @Override
    public User validateToken(String tokenValue) {
        return null;
    }
}
