package kr.co.planhub.planhub.users.services;

import kr.co.planhub.planhub.domain.users.Users;
import kr.co.planhub.planhub.domain.users.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class UsersServicesImpl implements UsersServices{
    private final UsersRepository usersRepository;

    public UsersServicesImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public Users save(String email, String password) {
        return usersRepository.save(Users.create(email, password));
    }
}
