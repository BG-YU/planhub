package kr.co.planhub.domain.task;

import java.util.List;

public interface TaskCustomRepository {
    List<Task> findAll(TaskSearchCondition condition);
}
