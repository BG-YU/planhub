package kr.co.planhub.services.subtask;

import kr.co.planhub.domain.task.SubTask;

import java.util.List;

public interface SubTaskService {
    List<SubTask> findAll(Long taskId);
}
