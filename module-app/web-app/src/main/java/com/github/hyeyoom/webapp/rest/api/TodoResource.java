package com.github.hyeyoom.webapp.rest.api;

import com.github.hyeyoom.webapp.rest.api.dto.CreateTodoParam;
import com.github.hyeyoom.webapp.rest.api.dto.TodoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletionStage;

@RestController
@RequestMapping("/todos")
public interface TodoResource {

    @GetMapping("/{id}")
    CompletionStage<ResponseEntity<TodoResponse>> getTodo(@PathVariable String id);

    @PostMapping
    CompletionStage<ResponseEntity> createTodo(@RequestBody CreateTodoParam param);

}
