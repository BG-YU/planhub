package kr.co.planhub.services.users;

import kr.co.planhub.domain.users.Users;
import kr.co.planhub.domain.users.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;

    @Override
    public Users save(String email, String password) {
        return usersRepository.save(Users.create(email, password));
    }
}
