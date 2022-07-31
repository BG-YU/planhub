package kr.co.planhub.domain.task;

import kr.co.planhub.domain.task.dto.UserTaskDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TaskCustomRepository {
    Page<UserTaskDTO> findTask(Pageable pageable, Long userId, Long id);
}
