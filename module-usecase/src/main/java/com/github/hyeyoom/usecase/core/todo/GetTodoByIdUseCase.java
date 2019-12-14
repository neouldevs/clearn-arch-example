package com.github.hyeyoom.usecase.core.todo;

import com.github.hyeyoom.core.Todo;
import com.github.hyeyoom.usecase.core.UseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetTodoByIdUseCase implements UseCase<String, Todo> {

    private final TodoRepository repository;

    @Override
    public Todo execute(String id) {
        return repository.findById(id);
    }

    public interface TodoRepository {
        Todo findById(String id);
    }
}
