package com.example.service;

import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class WelcomeService {

    public String welcome() throws SQLException {
         throw new SQLException();
    }

    @Retryable(value = {SQLException.class}, maxAttempts = 3)
    public String retrySuccess() throws SQLException {
         throw new SQLException();
    }

    @Recover
    public String recover(SQLException t) {
        return "Service recovered from failure.";
    }
}
