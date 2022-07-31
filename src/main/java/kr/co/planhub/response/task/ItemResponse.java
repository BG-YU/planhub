package kr.co.planhub.response.task;

import kr.co.planhub.domain.task.SubTask;
import kr.co.planhub.domain.task.enums.SubTaskCheckType;

public class ItemResponse {
    private final Long id;
    private final String item;
    private final SubTaskCheckType checkType;
    private final Integer sort;

    private ItemResponse(Long id, String item, SubTaskCheckType checkType, Integer sort) {
        this.id = id;
        this.item = item;
        this.checkType = checkType;
        this.sort = sort;
    }

    public static ItemResponse of(SubTask subTask) {
        return new ItemResponse(subTask.getId(), subTask.getItem(), subTask.getCheckType(), subTask.getSort());
    }
}
