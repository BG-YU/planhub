package kr.co.planhub.services.task;

import kr.co.planhub.domain.task.SubTask;
import kr.co.planhub.domain.task.Task;
import kr.co.planhub.domain.task.dto.UserTaskDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TaskService {
    Page<UserTaskDTO> findTask(Pageable pageable, Long userId, Long id);
    List<SubTask> createTask(Long userId, String title, List<String> item);
}
