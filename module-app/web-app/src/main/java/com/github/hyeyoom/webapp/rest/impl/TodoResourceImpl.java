package com.github.hyeyoom.webapp.rest.impl;

import com.github.hyeyoom.core.Todo;
import com.github.hyeyoom.usecase.core.UseCaseExecutorImpl;
import com.github.hyeyoom.usecase.core.todo.CreateTodoUseCase;
import com.github.hyeyoom.usecase.core.todo.GetTodoByIdUseCase;
import com.github.hyeyoom.webapp.rest.api.TodoResource;
import com.github.hyeyoom.webapp.rest.api.dto.CreateTodoParam;
import com.github.hyeyoom.webapp.rest.api.dto.TodoResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;

import java.util.concurrent.CompletionStage;

@Slf4j
@RequiredArgsConstructor
public class TodoResourceImpl implements TodoResource {

    private final UseCaseExecutorImpl useCaseExecutor;

    private final CreateTodoUseCase createTodoUseCase;

    private final GetTodoByIdUseCase getTodoByIdUseCase;

    @Override
    public CompletionStage<ResponseEntity<TodoResponse>> getTodo(String id) {
        return useCaseExecutor.invoke(
                getTodoByIdUseCase,
                id,
                o -> id,
                todo -> ResponseEntity.ok(new TodoResponse().toResponse((Todo) todo))
        );
    }

    @Override
    public CompletionStage<ResponseEntity> createTodo(CreateTodoParam param) {
        log.info("param: {}", param);
        return useCaseExecutor.invoke(
                createTodoUseCase,
                param,
                o -> param.toEntity(),
                res -> ResponseEntity.ok()
        );
    }
}
