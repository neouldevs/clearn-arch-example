package com.github.hyeyoom.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
public class Todo {

    private String id = UUID.randomUUID().toString();

    private String title;

    private String content;

    private boolean isDone = false;

    private long createdAt = System.currentTimeMillis(); // timestamp
}
