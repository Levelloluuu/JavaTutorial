package com.renga.taskmanager;

import com.sun.source.tree.UsesTree;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
        private final List<Task> tasks = new ArrayList<>();
        private int nextId = 1;
        //追加
        public Task add(String title) {
            if (title == null || title.isBlank()) {
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
        public boolean updateTitle(int id, String newTitle){
            if (newTitle == null || newTitle.isBlank()) {
                System.out.println("タイトルは必須です");
                return false;
            }
            for (Task t : tasks) {
                if (t.getId() == id ){
                    t.setTitle(newTitle.trim());
                    return true;
                }
                }
            System.out.println("IDが見つかりません");
            return false;
            }

        //セーブ
        public boolean save (String path) {
            Path p = Paths.get(path);
            try (BufferedWriter w = Files.newBufferedWriter(p, StandardCharsets.UTF_8)){
                for (Task t : tasks){
                    w.write(t.getId() + "," + t.getTitle() + "," + t.isDone());
                    w.newLine();
                }
                return true;
            } catch (IOException e) {
                System.out.println("保存に失敗 "+e.getMessage());
                return false;
            }
        }
        //ロード
        public  boolean load (String path) {
        Path p = Paths.get(path);
        if (!Files.exists(p)) {
            System.out.println("ファイルがありません"+path);
            return false;
        }
            try (BufferedReader r = Files.newBufferedReader(p, StandardCharsets.UTF_8)) {
                tasks.clear();
                int maxId = 0;
                String line;
            while ((line = r.readLine()) != null ) {
                if(line.isBlank()) continue;

                String cols[] = line.split(",",3);
                int id = Integer.parseInt(cols[0]);
                String title = cols[1];
                boolean done =Boolean.parseBoolean(cols[2]);

                Task t = new Task(id,title);
                t.setDone(done);
                tasks.add(t);

                if (id > maxId)
                    maxId = id;
            }

            nextId = maxId + 1;
            return true;



        } catch (IOException r) {
            System.out.println("読み込みに失敗"+ r.getMessage());
            return false;
        }

        }

        }


