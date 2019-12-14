package com.github.hyeyoom.webapp.config;

import com.github.hyeyoom.data.file.repository.TodoFileRepository;
import com.github.hyeyoom.usecase.core.UseCaseExecutorImpl;
import com.github.hyeyoom.usecase.core.gateway.TodoRepository;
import com.github.hyeyoom.usecase.core.todo.CreateTodoUseCase;
import com.github.hyeyoom.usecase.core.todo.GetTodoByIdUseCase;
import com.github.hyeyoom.webapp.rest.impl.TodoResourceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExternalModuleConfiguration {

    @Bean
    public UseCaseExecutorImpl getUseCaseExecutor() {
        return new UseCaseExecutorImpl();
    }

    @Bean
    public TodoRepository todoRepository() {
        return new TodoFileRepository();
    }

    @Bean
    public GetTodoByIdUseCase getTodoByIdUseCase(TodoRepository todoRepository) {
        return new GetTodoByIdUseCase(todoRepository);
    }

    @Bean
    public CreateTodoUseCase createTodoUseCase(TodoRepository todoRepository) {
        return new CreateTodoUseCase(todoRepository);
    }

    @Bean
    public TodoResourceImpl getTodoResource(
            UseCaseExecutorImpl useCaseExecutor,
            CreateTodoUseCase createTodoUseCase,
            GetTodoByIdUseCase getTodoByIdUseCase
    ) {
        return new TodoResourceImpl(useCaseExecutor, createTodoUseCase, getTodoByIdUseCase);
    }
}
