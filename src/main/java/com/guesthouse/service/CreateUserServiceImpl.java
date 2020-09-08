package com.guesthouse.service;

import com.guesthouse.dto.UserRequest;
import com.guesthouse.dto.UserResponse;
import com.guesthouse.model.RoleEnum;
import com.guesthouse.model.User;
import com.guesthouse.utils.StringUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CreateUserServiceImpl  implements CreateUserService{

    private final StringUtil stringUtil;

    @Override
    public UserResponse createUser(UserRequest userRequest, List<RoleEnum> roleEnumList) {

        User user = new User();
//        Hibernate.
        user.setFirstName(stringUtil.capitalizeWord(userRequest.getFirstName().trim()));
        user.setLastName(stringUtil.capitalizeWord(userRequest.getLastName().trim()));

        
        return null;
    }
}
