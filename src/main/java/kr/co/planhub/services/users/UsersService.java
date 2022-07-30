package kr.co.planhub.services.users;

import kr.co.planhub.domain.users.Users;

public interface UsersService {
    Users save(String email, String password);
}
