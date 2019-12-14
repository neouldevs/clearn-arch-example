package com.github.hyeyoom.webapp;

import com.github.hyeyoom.webapp.todo.TodoAppManager;
import com.github.hyeyoom.core.Todo;

import java.util.concurrent.CompletionStage;

public class Application {

    public static void main(String[] args) throws InterruptedException {

        TodoAppManager app = new TodoAppManager();
        CompletionStage<Todo> todo = app.findById("e547485a-4f87-4755-8365-aaff3c01972c");
        System.out.println(todo.thenAccept(System.out::println));
        Thread.sleep(3000);
    }
}
