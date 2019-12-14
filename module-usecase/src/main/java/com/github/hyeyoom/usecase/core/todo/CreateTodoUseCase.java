package com.github.hyeyoom.usecase.core.todo;

import com.github.hyeyoom.core.Todo;
import com.github.hyeyoom.usecase.core.UseCase;

public class CreateTodoUseCase implements UseCase<Todo, Void> {

    private final TodoRepository repository;

    public CreateTodoUseCase(TodoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Void execute(Todo todo) {
        repository.save(todo);
        return null;
    }

    public interface TodoRepository {
        void save(Todo todo);
    }
}
