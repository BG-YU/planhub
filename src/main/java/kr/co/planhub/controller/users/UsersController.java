package kr.co.planhub.controller.users;

import kr.co.planhub.domain.users.Users;
import kr.co.planhub.request.user.CreateUserRequest;
import kr.co.planhub.services.users.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;

    @PostMapping
    public Users test(@RequestBody CreateUserRequest request) {
        return usersService.save(request.getEmail(), request.getPassword());
    }
}
