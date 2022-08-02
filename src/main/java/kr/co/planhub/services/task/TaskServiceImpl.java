package kr.co.planhub.services.task;

import kr.co.planhub.domain.task.*;
import kr.co.planhub.response.task.TaskResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;
    private final SubTaskRepository subTaskRepository;

    @Override
    public List<TaskResponse> pagingTasks(Long userId, Long taskId, Long pageSize) {
        return findSubTasksByTasks(findTasksBySearchCondition(userId, taskId, pageSize)).stream()
                .collect(groupingBy(SubTask::getTask))
                .entrySet()
                .stream()
                .map(TaskServiceImpl::convertToTaskResponse)
                .sorted(comparing(TaskResponse::getId).reversed())
                .collect(toList());
    }

    private static TaskResponse convertToTaskResponse(Map.Entry<Task, List<SubTask>> task) {
        return TaskResponse.of(
                task.getKey().getId(),
                task.getKey().getUserId(),
                task.getKey().getUpperId(),
                task.getKey().getTitle(),
                task.getKey().getReadCount(),
                convertToItemResponseList(task.getValue())
        );
    }

    private static List<TaskResponse.ItemResponse> convertToItemResponseList(List<SubTask> subTasks) {
        return subTasks.stream()
                .map(TaskServiceImpl::convertToItemResponse)
                .collect(toList());
    }

    private static TaskResponse.ItemResponse convertToItemResponse(SubTask subTask) {
        return TaskResponse.ItemResponse.of(
                subTask.getId(),
                subTask.getItem(),
                subTask.getCheckType(),
                subTask.getSort());
    }

    private List<Task> findTasksBySearchCondition(Long userId, Long taskId, Long pageSize) {
        return findAllTasks(pagingCondition(userId, taskId, pageSize));
    }

    private List<Task> findAllTasks(TaskSearchCondition condition) {
        return taskRepository.findAll(condition);
    }

    private TaskSearchCondition pagingCondition(Long userId, Long taskId, Long pageSize) {
        return TaskSearchCondition.pagingCondition(userId, taskId, pageSize);
    }

    private List<SubTask> findSubTasksByTasks(List<Task> tasks) {
        return subTaskRepository.findAllByTaskIn(tasks);
    }

    @Override
    @Transactional
    public List<SubTask> createTask(Long userId, String title, List<String> items) {
        return create(userId, title, items);
    }

    private List<SubTask> create(Long userId, String title, List<String> items) {
        return createSubTask(createTask(userId, title), items);
    }

    private Task createTask(Long userId, String title) {
        return taskRepository.save(Task.create(userId, title));
    }

    private List<SubTask> createSubTask(Task task, List<String> items) {
        return subTaskRepository.saveAll(createItems(task, items));
    }

    private List<SubTask> createItems(Task task, List<String> items) {
        final int INIT_ATOMIC_VALUE = 1;
        AtomicInteger sort = new AtomicInteger(INIT_ATOMIC_VALUE);
        return items.stream()
                .map(item -> SubTask.create(task, item, sort.getAndIncrement()))
                .collect(toList());
    }
}
