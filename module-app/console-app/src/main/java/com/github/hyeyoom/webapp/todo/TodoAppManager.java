package com.github.hyeyoom.webapp.todo;

import com.github.hyeyoom.webapp.todo.dto.CreateTodoDto;
import com.github.hyeyoom.core.Todo;
import com.github.hyeyoom.data.file.repository.TodoFileRepository;
import com.github.hyeyoom.usecase.core.UseCaseExecutorImpl;
import com.github.hyeyoom.usecase.core.todo.CreateTodoUseCase;
import com.github.hyeyoom.usecase.core.todo.GetTodoByIdUseCase;

import java.util.concurrent.CompletionStage;

public class TodoAppManager {

    private TodoFileRepository todoFileRepository;

    private CreateTodoUseCase createTodoUseCase;

    private GetTodoByIdUseCase getTodoByIdUseCase;

    private UseCaseExecutorImpl useCaseExecutor;

    public TodoAppManager() {
        this.todoFileRepository = new TodoFileRepository();
        this.createTodoUseCase = new CreateTodoUseCase(todoFileRepository);
        this.getTodoByIdUseCase = new GetTodoByIdUseCase(todoFileRepository);
        this.useCaseExecutor = new UseCaseExecutorImpl();
    }

    public void saveTodo(CreateTodoDto dto) {
        useCaseExecutor.invoke(
                createTodoUseCase,
                dto,
                o -> dto.toEntity(),
                x -> x
        );
    }

    public CompletionStage<Todo> findById(String id) {
        return useCaseExecutor.invoke(
                getTodoByIdUseCase,
                id,
                x -> id,
                y -> y
        );
    }
}
