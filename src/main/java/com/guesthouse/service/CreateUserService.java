package com.guesthouse.service;

import com.guesthouse.dto.UserRequest;
import com.guesthouse.dto.UserResponse;
import com.guesthouse.model.RoleEnum;

import java.util.List;

public interface CreateUserService {

    UserResponse createUser(UserRequest userRequest, List<RoleEnum> roleEnumList);
}

