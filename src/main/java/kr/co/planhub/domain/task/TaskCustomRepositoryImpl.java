package kr.co.planhub.domain.task;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.co.planhub.domain.task.dto.UserTaskDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

import static kr.co.planhub.domain.task.QSubTask.subTask;

@Repository
@RequiredArgsConstructor
public class TaskCustomRepositoryImpl implements TaskCustomRepository{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Page<UserTaskDTO> findTask(Pageable pageable, Long userId, Long id) {
        JPAQuery<UserTaskDTO> test = jpaQueryFactory.select(
                Projections.constructor(UserTaskDTO.class,
                        subTask.task.id.as("taskId"),
                        subTask.task.userId,
                        subTask.task.upperId,
                        subTask.task.title,
                        subTask.task.readCount,
                        subTask.id.as("subTaskId"),
                        subTask.item,
                        subTask.checkType,
                        subTask.sort
                ))
                .from(subTask)
                .innerJoin(subTask.task)
                .where(subTask.task.userId.eq(userId),
                        subTask.task.id.gt(id))
                .orderBy(subTask.sort.asc());

        List<UserTaskDTO> userTasks = test.fetch();
        return new PageImpl<>(userTasks, pageable, userTasks.size());
    }
}
