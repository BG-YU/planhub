package kr.co.planhub.domain.task;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubTaskRepository extends JpaRepository<SubTask, Long> {
    List<SubTask> findAllByTaskIn(List<Task> tasks);
}
