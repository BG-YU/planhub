package kr.co.planhub.services.task;

import kr.co.planhub.domain.task.SubTask;
import kr.co.planhub.domain.task.SubTaskRepository;
import kr.co.planhub.domain.task.Task;
import kr.co.planhub.domain.task.TaskRepository;
import kr.co.planhub.response.task.TaskResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;
    private final SubTaskRepository subTaskRepository;

    @Override
    public List<TaskResponse> findTask(Long userId, Long id) {
        List<Task> tasks = taskRepository.findAllByUserIdAndIdLessThanOrderByIdDesc(userId, id);
        List<SubTask> subTasks = subTaskRepository.findAllByTaskIn(tasks);
        return subTasks.stream()
                .collect(groupingBy(SubTask::getTask))
                .entrySet()
                .stream()
                .map(task -> TaskResponse.of(
                        task.getKey().getId(),
                        task.getKey().getUserId(),
                        task.getKey().getUpperId(),
                        task.getKey().getTitle(),
                        task.getKey().getReadCount(),
                        task.getValue()
                                .stream()
                                .map(subTask -> TaskResponse.ItemResponse.of(
                                        subTask.getId(),
                                        subTask.getItem(),
                                        subTask.getCheckType(),
                                        subTask.getSort()))
                                .collect(toList())
                ))
                .collect(toList());
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
        AtomicInteger sort = new AtomicInteger(1);
        return items.stream()
                .map(item -> SubTask.create(task, item, sort.getAndIncrement()))
                .collect(toList());
    }
}
