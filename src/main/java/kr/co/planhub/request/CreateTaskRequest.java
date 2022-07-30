package kr.co.planhub.request;

import lombok.Getter;

@Getter
public class CreateTaskRequest {
    private Long userId;
    private String title;
    private String item;

    @Override
    public String toString() {
        return "CreateTaskRequest{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", item='" + item + '\'' +
                '}';
    }
}
