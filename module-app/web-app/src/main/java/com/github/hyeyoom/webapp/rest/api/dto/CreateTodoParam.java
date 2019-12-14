package com.github.hyeyoom.webapp.rest.api.dto;

import com.github.hyeyoom.core.Todo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateTodoParam {

    private String title;

    private String content;

    public Todo toEntity() {
        Todo todo = new Todo();
        todo.setTitle(title);
        todo.setContent(content);
        return todo;
    }
}
