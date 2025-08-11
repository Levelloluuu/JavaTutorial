package com.renga.taskmanager;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
        private final List<Task> tasks = new ArrayList<>();
        private int nextId = 1;
        //追加
        public Task add(String title) {
            if (title == null || title.trim().isEmpty()) {
                System.out.println("タイトルは必須です");
            }
            Task task = new Task(nextId, title);
            tasks.add(task);
            nextId++;
            return task;
        }
        //リスト
        public List<Task> list() {
            return tasks;
        }
        //切り替え
        public boolean toggle(int id) {
            for (Task t : tasks) {
                if (t.getId() == id) {
                    t.setDone(!t.isDone());
                    return true;
                }
            }
            return false;
        }
        //削除
        public boolean delete (int id) {
            return  tasks.removeIf(t -> t.getId() == id);
        }

        //タイトル変更
        public boolean updatedTitle(int id, String newTitle){
            for (Task t: tasks) {
                if (t.getId() == id){
                    t.setTitle(newTitle);
                }
            }
        }
}

