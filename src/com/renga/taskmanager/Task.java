package com.renga.taskmanager;

public class Task {
    //自動連番で入る
    private final int id;
    //1～50文字
    private String title;
    //最初はfalse
    private boolean done;

    public Task (int id, String title) {
        this.id = id;
        this.title =(title == null)? "" : title.trim();
        this.done = false;
    }
    //getter
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isDone() {
        return done;
    }
    //setter
    public void setTitle (String title) {
        this.title = title;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return String.format("[%d] %s (%s)", id, title, done ? "DONE" : "TODO");
    }
}
