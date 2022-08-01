package kr.co.planhub.response.task;

import kr.co.planhub.domain.task.enums.SubTaskCheckType;
import lombok.Getter;

import java.util.List;

@Getter
public class TaskResponse {
    private final Long id;
    private final Long userId;
    private final Long upperId;
    private final String title;
    private final Integer readCount;
    private final List<ItemResponse> items;

    private TaskResponse(Long id, Long userId, Long upperId, String title, Integer readCount, List<ItemResponse> items) {
        this.id = id;
        this.userId = userId;
        this.upperId = upperId;
        this.title = title;
        this.readCount = readCount;
        this.items = items;
    }

    public static TaskResponse of(Long id, Long userId, Long upperId, String title, Integer readCount, List<ItemResponse> items) {
        return new TaskResponse(id, userId, upperId, title, readCount, items);
    }

    @Getter
    public static class ItemResponse {
        private final Long id;
        private final String item;
        private final SubTaskCheckType  checkType;
        private final Integer sort;

        private ItemResponse(Long id, String item, SubTaskCheckType checkType, Integer sort) {
            this.id = id;
            this.item = item;
            this.checkType = checkType;
            this.sort = sort;
        }

        public static ItemResponse of(Long id, String item, SubTaskCheckType checkType, Integer sort) {
            return new ItemResponse(id, item, checkType, sort);
        }
    }
}
