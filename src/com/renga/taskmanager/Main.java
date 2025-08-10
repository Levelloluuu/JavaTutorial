package com.renga.taskmanager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager tm = new TaskManager();
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("\n=== Task Manager ===");
            System.out.println("1: 追加 2: リスト 0) 終了");
            System.out.println(">");
            String choice = sc.nextLine().trim();

            switch (choice){
                case "1":
                    System.out.println("タイトル: ");
                    String title = sc.nextLine();
                    System.out.println(tm.add(title));
                    break;

                case "2":
                    for (int i = 0; i < tm.list().size(); i++){
                        System.out.println(tm.list().get(i));
                    }
                    break;
                case "0":
                    System.out.println("終了");
                    break;

                default:
                    System.out.println("0～2を選んでね");

            }
        }
    }
}
