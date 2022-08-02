package kr.co.planhub.domain.task;

import lombok.Builder;
import lombok.Getter;

@Getter
public class TaskSearchCondition {

    private final Long userId;
    private final Long id;
    private final Long pageSize;

    @Builder
    public TaskSearchCondition(Long userId, Long id, Long pageSize) {
        this.userId = userId;
        this.id = id;
        this.pageSize = pageSize;
    }

    public static TaskSearchCondition pagingCondition(Long userId, Long id, Long pageSize) {
        return TaskSearchCondition.builder()
                .userId(userId)
                .id(id)
                .pageSize(pageSize)
                .build();
    }
}
