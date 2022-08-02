package kr.co.planhub.request.user;

import lombok.Getter;

@Getter
public class CreateUserRequest {
    private String email;
    private String password;
}
