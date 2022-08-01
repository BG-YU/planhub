package kr.co.planhub.services.task;

import kr.co.planhub.domain.task.SubTask;
import kr.co.planhub.response.task.TaskResponse;

import java.util.List;

public interface TaskService {
    List<TaskResponse> findTask(Long userId, Long id);
    List<SubTask> createTask(Long userId, String title, List<String> item);
}
