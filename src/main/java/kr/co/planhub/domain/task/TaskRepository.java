package kr.co.planhub.domain.task;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByUserIdAndIdLessThanOrderByIdDesc(Long userId, Long id);
}
