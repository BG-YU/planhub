package kr.co.planhub.controller.task;

import kr.co.planhub.domain.task.SubTask;
import kr.co.planhub.request.task.CreateTaskRequest;
import kr.co.planhub.response.task.TaskResponse;
import kr.co.planhub.services.task.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public List<TaskResponse> pagingTasks(
            @RequestParam(value = "userId") Long userId,
            @RequestParam(value = "taskId", required = false) Long taskId,
            @RequestParam(value = "pageSize") Long pageSize) {
        return taskService.pagingTasks(userId, taskId, pageSize);
    }

    @PostMapping
    public List<SubTask> createTask(@RequestBody CreateTaskRequest request) {
        return taskService.createTask(
                request.getUserId(), request.getTitle(), request.getItem());
    }
}