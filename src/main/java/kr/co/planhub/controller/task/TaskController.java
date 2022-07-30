package kr.co.planhub.controller.task;

import kr.co.planhub.domain.task.SubTask;
import kr.co.planhub.domain.task.Task;
import kr.co.planhub.request.CreateTaskRequest;
import kr.co.planhub.services.subtask.SubTaskService;
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
    private final SubTaskService subTaskService;

    @GetMapping("/{id:\\d+}")
    public List<SubTask> findTask(@PathVariable("id") Long id) {
        return subTaskService.findAll(id);
    }

    @PostMapping
    public Task createTask(@RequestBody CreateTaskRequest request) {
        log.info("request : {}" + request.toString());
        return taskService.save(request.getUserId(), request.getTitle(), request.getItem());
    }
}
