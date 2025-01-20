package com.scaler.userservicejan25.repositories;

import com.scaler.userservicejan25.models.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {
    @Override
    Token save(Token token);

    Optional<Token> findByTokenValue(String tokenValue);
}