package com.eureka.micro.auth.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserCredentials {
    private String username;
    private String password;
}