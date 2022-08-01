package kr.co.planhub.domain.task;

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
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
public class Task {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "upper_id")
    private Long upperId;

    @Column(name = "title", length = 200, nullable = false)
    private String title;

    @Column(name = "count", nullable = false)
    private Integer readCount;

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
    public Task(Long userId, String title) {
        this.userId = userId;
        this.title = title;
        this.readCount = 0;
        this.createdId = userId;
        this.updatedId = userId;
    }

    public static Task create(Long id, String title) {
        return Task.builder()
                .userId(id)
                .title(title)
                .build();
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", userId=" + userId +
                ", upperId=" + upperId +
                ", title='" + title + '\'' +
                ", readCount=" + readCount +
                ", createdAt=" + createdAt +
                ", createdId=" + createdId +
                ", updatedAt=" + updatedAt +
                ", updatedId=" + updatedId +
                '}';
    }
}
