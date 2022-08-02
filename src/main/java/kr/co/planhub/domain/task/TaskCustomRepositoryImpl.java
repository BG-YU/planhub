package kr.co.planhub.domain.task;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static kr.co.planhub.domain.task.QTask.task;

@Repository
@RequiredArgsConstructor
public class TaskCustomRepositoryImpl implements TaskCustomRepository{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Task> findAll(TaskSearchCondition condition) {
        return jpaQueryFactory.selectFrom(task)
                .where(
                        ltTaskId(condition.getId()),
                        task.userId.eq(condition.getUserId())
                )
                .orderBy(task.id.desc())
                .limit(condition.getPageSize())
                .fetch();
    }

    private BooleanExpression ltTaskId(Long taskId) {
        if (taskId == null) {
            return null;
        }

        return task.id.lt(taskId);
    }
}
