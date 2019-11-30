package com.github.hyeyoom.todo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        final Todo todo = readTodoFromFile("4bb99e38-52eb-4c3c-8dd7-a4b868a9748f");
        System.out.println(todo);
        // file format : text
        // file content: json
        // file name: {UUID}.json
    }

    private static void saveTodo(Todo todo) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        final String json = mapper.writeValueAsString(todo);
        final String filename = String.format("%s.json", todo.getId());
        final File file = new File(filename);
        FileUtils.write(file, json);
    }

    private static Todo readTodoFromFile(String id) throws IOException {
        System.out.println(String.format("id: %s", id));
        String raw = FileUtils.readFileToString(new File(String.format("%s.json", id)));
        final ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(raw, Todo.class);
    }
}
