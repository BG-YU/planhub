package kr.co.planhub.domain.task;

import kr.co.planhub.domain.task.enums.SubTaskCheckType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Getter
@Table(name = "sub_task", indexes = @Index(name = "uc_subtask_id", columnList = "id", unique = true))
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
public class SubTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id")
    private Task task;

    @Column(name = "item", nullable = false)
    private String item;

    @Enumerated(EnumType.STRING)
    @Column(name = "`check`", nullable = false)
    private SubTaskCheckType checkType;

    @Column(name = "sort", nullable = false)
    private Integer sort;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "created_id", nullable = false, updatable = false)
    private Long createdId;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "updated_id", nullable = false)
    private Long updatedId;

    @Builder
    public SubTask(Task task, String item, SubTaskCheckType checkType, Integer sort) {
        this.task = task;
        this.item = item;
        this.checkType = checkType;
        this.sort = sort;
        this.createdId = task.getUserId();
        this.updatedId = task.getUserId();
    }

    public static SubTask create(Task task, String item, Integer sort) {
        return SubTask.builder()
                .task(task)
                .item(item)
                .checkType(SubTaskCheckType.UN_CHECK)
                .sort(sort)
                .build();
    }

    @Override
    public String toString() {
        return "SubTask{" +
                "id=" + id +
                ", task=" + task +
                ", item='" + item + '\'' +
                ", checkType=" + checkType +
                ", sort=" + sort +
                ", createdAt=" + createdAt +
                ", createdId=" + createdId +
                ", updatedAt=" + updatedAt +
                ", updatedId=" + updatedId +
                '}';
    }
}
