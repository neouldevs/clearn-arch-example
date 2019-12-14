package com.github.hyeyoom.webapp.rest.api.dto;

import com.github.hyeyoom.core.Todo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
public class TodoResponse {

    private String id;

    private String title;

    private String content;

    private boolean isDone;

    private Timestamp createdAt;

    public TodoResponse toResponse(Todo todo) {
        TodoResponse tr = new TodoResponse();
        tr.setId(todo.getId());
        tr.setTitle(todo.getTitle());
        tr.setContent(todo.getContent());
        tr.setDone(todo.isDone());
        tr.setCreatedAt(new Timestamp(todo.getCreatedAt()));
        return tr;
    }
}
