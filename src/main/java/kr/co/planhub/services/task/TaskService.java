package kr.co.planhub.services.task;

import kr.co.planhub.domain.task.Task;
import kr.co.planhub.domain.users.Users;

public interface TaskService {
    Task save(Long userId, String title, String item);
}
