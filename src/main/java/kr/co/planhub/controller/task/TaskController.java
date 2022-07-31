package kr.co.planhub.controller.task;

import kr.co.planhub.domain.task.SubTask;
import kr.co.planhub.domain.task.dto.UserTaskDTO;
import kr.co.planhub.request.task.CreateTaskRequest;
import kr.co.planhub.services.task.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/user/{id:\\d+}/task/{taskId:\\d+}")
    public Page<UserTaskDTO> findTask(Pageable pageable, @PathVariable("id") Long userId, @PathVariable("taskId") Long id) {
        return taskService.findTask(pageable, userId, id);
    }

    @PostMapping
    public List<SubTask> createTask(@RequestBody CreateTaskRequest request) {
        log.info("request : {}", request.toString());
        System.out.println(String.join(",", new String[]{"시간이요", String.valueOf(LocalDateTime.now())}));
        return taskService.createTask(request.getUserId(), request.getTitle(), request.getItem());
    }
}