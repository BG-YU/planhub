package kr.co.planhub.planhub.users.services;

import kr.co.planhub.planhub.domain.users.Users;

public interface UsersServices {
    Users save(String email, String password);
}
