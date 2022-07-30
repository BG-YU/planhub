package kr.co.planhub.services.subtask;

import kr.co.planhub.domain.task.SubTask;
import kr.co.planhub.domain.task.SubTaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubTaskServiceImpl implements SubTaskService{

    private final SubTaskRepository subTaskRepository;

    @Override
    public List<SubTask> findAll(Long taskId) {
        return subTaskRepository.findAllByTask_Id(taskId);
    }
}
