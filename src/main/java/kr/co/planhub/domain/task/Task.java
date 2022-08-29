package kr.co.planhub.domain.task;

import kr.co.planhub.domain.common.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Getter
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
public class Task extends BaseEntity {

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "upper_id")
    private Long upperId;

    @Column(name = "title", length = 200, nullable = false)
    private String title;

    @Column(name = "count", nullable = false)
    private Integer readCount;


    @Builder
    private Task(Long userId, String title) {
        super();
        this.userId = userId;
        this.title = title;
        this.readCount = 0;
    }

    public static Task create(Long id, String title) {
        return Task.builder()
                .userId(id)
                .title(title)
                .build();
    }
}
