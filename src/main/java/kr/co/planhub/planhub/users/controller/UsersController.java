package kr.co.planhub.planhub.users.controller;

import kr.co.planhub.planhub.domain.users.Users;
import kr.co.planhub.planhub.users.request.CreateUserRequest;
import kr.co.planhub.planhub.users.services.UsersServices;
import kr.co.planhub.planhub.users.services.UsersServicesImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users")
public class UsersController {
    private final UsersServices usersServices;

    public UsersController(UsersServicesImpl usersServices) {
        this.usersServices = usersServices;
    }

    @PostMapping
    public Users test(@RequestBody CreateUserRequest request) {
        return usersServices.save(request.getEmail(), request.getPassword());
    }

}
