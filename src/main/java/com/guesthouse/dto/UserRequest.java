package com.guesthouse.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class UserRequest {

    private String firstName;

    private String lastName;

    private String email;

    private String password;
}
