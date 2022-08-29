package kr.co.planhub.controller.task;

import kr.co.planhub.request.task.CreateTaskRequest;
import kr.co.planhub.response.Response;
import kr.co.planhub.services.task.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/v1/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public Response pagingTasks(
            @RequestParam(value = "userId") Long userId,
            @RequestParam(value = "taskId", required = false) Long taskId,
            @RequestParam(value = "pageSize") Long pageSize) {
        return Response.of()
                .addObject(taskService.pagingTasks(userId, taskId, pageSize));
    }

    @PostMapping
    public Response createTask(@RequestBody CreateTaskRequest request) {
        return Response.of()
                .addObject(
                        taskService.createTask(
                                request.getUserId(), request.getTitle(), request.getItem()));
    }

//    @GetMapping
//    public Response search(@RequestParam(value = "keyword", required = true) String keyword) {
//        return taskService.search();
//    }
}