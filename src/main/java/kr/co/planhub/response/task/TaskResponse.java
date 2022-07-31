//package kr.co.planhub.response.task;
//
//import kr.co.planhub.domain.task.SubTask;
//import kr.co.planhub.domain.task.Task;
//import kr.co.planhub.domain.task.enums.SubTaskCheckType;
//import lombok.Getter;
//import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
//
//import java.io.Serializable;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Getter
//public class TaskResponse implements Serializable {
//    private final Long id;
//    private final Long userId;
//    private final Long upperId;
//    private final String title;
//    private final Long readCount;
//    private final List<ItemResponse> items;
//
//
//    private TaskResponse(Long id, Long userId, Long upperId, String title, Long readCount, List<SubTask> items) {
//        this.id = id;
//        this.userId = userId;
//        this.upperId = upperId;
//        this.title = title;
//        this.readCount = readCount;
//        this.items = items.stream().map(ItemResponse::of).collect(Collectors.toList());
//    }
//
//    public static TaskResponse of(Task task) {
//        return new TaskResponse(task.getId(), task.getUserId(), task.getUpperId(), task.getTitle(), task.getReadCount());
//    }
//
//    private static class ItemResponse {
//        private final Long id;
//        private final String item;
//        private final SubTaskCheckType  checkType;
//        private final Integer sort;
//
//        private ItemResponse(Long id, String item, SubTaskCheckType checkType, Integer sort) {
//            this.id = id;
//            this.item = item;
//            this.checkType = checkType;
//            this.sort = sort;
//        }
//
//        private static ItemResponse of(SubTask subTask) {
//            return new ItemResponse(subTask.getId(), subTask.getItem(), subTask.getCheckType(), subTask.getSort());
//        }
//    }
//}
