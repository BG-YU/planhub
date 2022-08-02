package kr.co.planhub.request.task;

import lombok.Getter;

import java.util.List;

@Getter
public class CreateTaskRequest {
    private Long userId;
    private String title;
    private List<String> item;
}
