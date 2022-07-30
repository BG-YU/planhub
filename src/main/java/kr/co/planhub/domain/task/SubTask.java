package kr.co.planhub.domain.task;

import kr.co.planhub.domain.task.enums.SubTaskCheckType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

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

    @JoinColumn(name = "task_id")
    @ManyToOne(targetEntity = Task.class, fetch = FetchType.LAZY)
    private Task task;

    @Column(name = "item", nullable = false)
    private String item;

    @Enumerated(EnumType.STRING)
    @Column(name = "`check`", nullable = false)
    private SubTaskCheckType checkType;

    @Column(name = "sort", nullable = false)
    private Long sort;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "created_id", nullable = false)
    private Long createdId;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "updated_id", nullable = false)
    private Long updatedId;

    @Builder
    public SubTask(Task task, String item, SubTaskCheckType checkType, Long sort, Long createdId, Long updatedId) {
        this.task = task;
        this.item = item;
        this.checkType = checkType;
        this.sort = sort;
        this.createdId = createdId;
        this.createdAt = LocalDateTime.now();
        this.updatedId = updatedId;
        this.updatedAt = LocalDateTime.now();
    }

    public static SubTask create(Task task, Long userId, String item) {
        return SubTask.builder()
                .task(task)
                .item(item)
                .checkType(SubTaskCheckType.UN_CHECK)
                .sort(1L)
                .createdId(1L)
                .updatedId(1L)
                .build();
    }
}
