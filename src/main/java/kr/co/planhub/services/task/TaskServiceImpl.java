package kr.co.planhub.services.task;

import kr.co.planhub.domain.task.SubTask;
import kr.co.planhub.domain.task.SubTaskRepository;
import kr.co.planhub.domain.task.Task;
import kr.co.planhub.domain.task.TaskRepository;
import kr.co.planhub.domain.task.dto.UserTaskDTO;
import kr.co.planhub.response.task.ItemResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;
    private final SubTaskRepository subTaskRepository;

    @Override
    public Page<UserTaskDTO> findTask(Pageable pageable, Long userId, Long id) {
        return taskRepository.findTask(pageable, userId, id);
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
