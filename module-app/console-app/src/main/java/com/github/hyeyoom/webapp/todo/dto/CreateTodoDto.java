package com.github.hyeyoom.webapp.todo.dto;

import com.github.hyeyoom.core.Todo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateTodoDto {

    private String title;

    private String content;

    public Todo toEntity() {
        final Todo todo = new Todo();
        todo.setTitle(title);
        todo.setContent(content);
        return todo;
    }
}
