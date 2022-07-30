package kr.co.planhub.services.task;

import kr.co.planhub.domain.task.SubTask;
import kr.co.planhub.domain.task.SubTaskRepository;
import kr.co.planhub.domain.task.Task;
import kr.co.planhub.domain.task.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;
    private final SubTaskRepository subTaskRepository;

    @Override
    @Transactional
    public Task save(Long userId, String title, String item) {
        Task task = taskRepository.save(Task.create(userId, title));
        return subTaskRepository.save(SubTask.create(task, userId, item)).getTask();
    }
}
