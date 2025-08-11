package com.renga.taskmanager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager tm = new TaskManager();
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("\n=== Task Manager ===");
            System.out.println("1: 追加 2: リスト 3: 切り替え 4: 削除 0: 終了");
            System.out.println(">");
            String choice = sc.nextLine().trim();

            switch (choice){
                //追加
                case "1":
                    System.out.println("タイトル: ");
                    String title = sc.nextLine();
                    System.out.println(tm.add(title));
                    break;
                //リスト列挙
                case "2":
                    for (int i = 0; i < tm.list().size(); i++){
                        System.out.println(tm.list().get(i));
                    }
                    break;
                //切替
                case "3":
                    System.out.println("切り替えるタスクID");
                    int id = sc.nextInt();
                    sc.nextLine();
                    if(tm.toggle(id))
                        System.out.println("状態を切り替えました");
                    else
                        System.out.println("見つかりません");
                    break;
                //削除
                case "4":
                    System.out.println("削除するID");
                    int  d = sc.nextInt();
                    sc.nextLine();
                    if (tm.delete(d))
                        System.out.println("削除しました");
                    else
                        System.out.println("見つかりません");
                    break;
                case "0":
                    System.out.println("終了");
                    return;

                default:
                    System.out.println("0～2を選んでね");

            }
        }
    }
}
