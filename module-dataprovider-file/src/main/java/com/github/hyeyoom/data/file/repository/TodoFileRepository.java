package com.github.hyeyoom.data.file.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.hyeyoom.core.Todo;
import com.github.hyeyoom.usecase.core.gateway.TodoRepository;
import org.apache.commons.io.FileUtils;

import java.io.File;

public class TodoFileRepository implements TodoRepository {

    @Override
    public void save(Todo todo) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String json = mapper.writeValueAsString(todo);
            final String filename = String.format("%s.json", todo.getId());
            final File file = new File(filename);
            FileUtils.write(file, json);
        } catch (Exception ignore) {
        }
    }

    @Override
    public Todo findById(String id) {
        try {
            String raw = FileUtils.readFileToString(new File(String.format("%s.json", id)));
            final ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(raw, Todo.class);
        } catch (Exception ignore) {}
        return null;
    }

}
