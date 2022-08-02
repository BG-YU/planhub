package kr.co.planhub.services.task;

import kr.co.planhub.domain.task.SubTask;
import kr.co.planhub.response.task.TaskResponse;

import java.util.List;

public interface TaskService {
    List<TaskResponse> pagingTasks(Long userId, Long taskId, Long pageSize);
    List<SubTask> createTask(Long userId, String title, List<String> item);
}
