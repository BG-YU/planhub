package kr.co.planhub.domain.task.dto;

import kr.co.planhub.domain.task.enums.SubTaskCheckType;
import lombok.Getter;

@Getter
public class UserTaskDTO {
    private final Long taskId;
    private final Long userId;
    private final Long upperId;
    private final String title;
    private final Integer readCount;
    private final Long subTaskId;
    private final String item;
    private final SubTaskCheckType checkType;
    private final Integer sort;

    public UserTaskDTO(Long taskId, Long userId, Long upperId, String title, Integer readCount, Long subTaskId, String item, SubTaskCheckType checkType, Integer sort) {
        this.taskId = taskId;
        this.userId = userId;
        this.upperId = upperId;
        this.title = title;
        this.readCount = readCount;
        this.subTaskId = subTaskId;
        this.item = item;
        this.checkType = checkType;
        this.sort = sort;
    }
}
