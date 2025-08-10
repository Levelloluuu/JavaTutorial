package com.renga.taskmanager;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
        private final List<Task> tasks = new ArrayList<>();
        private int nextId = 1;

        public Task add(String title) {
            if (title == null || title.trim().isEmpty()) {
                System.out.println("タイトルは必須です");
            }
            Task task = new Task(nextId, title); //タスク追加
            tasks.add(task);
            nextId++;
            return task;
        }
        public List<Task> list() {
            return tasks;
        }

}

