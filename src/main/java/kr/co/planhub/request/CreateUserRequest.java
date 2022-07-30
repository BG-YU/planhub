package kr.co.planhub.request;

import lombok.Getter;

@Getter
public class CreateUserRequest {
    private String email;
    private String password;
}
