package kr.co.planhub.planhub.users.request;

import lombok.Getter;

@Getter
public class CreateUserRequest {
    private String email;
    private String password;
}
