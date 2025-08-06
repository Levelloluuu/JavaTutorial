package com.renga.numbergame;

import java.util.Random;
import java.util.Scanner;

public class GuessGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        mainloop:
        while (true){
            int answer = new Random().nextInt(10) + 1;

            gameloop:
            for (int i = 3; i > 0; ){
                System.out.println("1~10の数字を思い浮かべているよ３回以内に当ててみて！");
                if (scanner.hasNextInt()){
                    int input = scanner.nextInt();
                    if (input == answer) {
                        System.out.println("大正解");
                        break;
                    } else {
                        if (answer >= 1 && answer <= 3) {
                            System.out.println("ヒント：答えは 1 ～ 3 のどれかだよ");
                            System.out.println("残り" + --i + "回");
                        } else if (answer >= 4 && answer <= 7) {
                            System.out.println("ヒント：答えは 4 ～ 7 のどれかだよ");
                            System.out.println("残り" + --i + "回");
                        } else if (answer >= 8 && answer <= 10){
                            System.out.println("ヒント：答えは 8 ～ 10 のどれかだよ");
                            System.out.println("残り" + --i + "回");
                        } else {
                            System.out.println("ヒント:答えは 1 ～ 10 のどれかだよ");
                            System.out.println("残り" + --i + "回");
                        }
                    }
                }else {
                    System.out.println("正しい数値を入力してください");
                    continue gameloop;
                }
            }
            System.out.println("ゲームを続けますか？");
            System.out.println("1:はい");
            System.out.println("2:いいえ");;
            int  choice;

            if (scanner.hasNextInt()){
                choice = scanner.nextInt();

                if (choice == 1) {
                    System.out.println("ゲームを続けます！");
                    continue mainloop;
                } else if (choice == 2) {
                    System.out.println("ゲームを終了します。");
                    break;
                } else {
                    System.out.println("1か2を入力してください。");
                }
            } else {
                System.out.println("数字で入力してください。");
                scanner.next(); // 変な入力を読み捨てる
            }
        }

    }
}