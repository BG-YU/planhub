package kr.co.planhub.domain.task;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

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
    private Long readCount;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "created_id", nullable = false)
    private Long createdId;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "updated_id", nullable = false)
    private Long updatedId;

    @Builder
    public Task(Long userId, String title) {
        this.userId = 1L;
        this.title = "test";
        this.readCount = 100L;
        this.createdId = 1L;
        this.createdAt = LocalDateTime.now();
        this.updatedId = 1L;
        this.updatedAt = LocalDateTime.now();
    }

    public static Task create(Long id, String title) {
        return Task.builder()
                .userId(id)
                .title(title)
                .build();
    }
}
