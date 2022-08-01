package kr.co.planhub.request.task;

import lombok.Getter;

import java.util.List;

@Getter
public class CreateTaskRequest {
    private Long userId;
    private String title;
    private List<String> item;

    @Override
    public String toString() {
        return "CreateTaskRequest{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", item=" + item +
                '}';
    }
}
