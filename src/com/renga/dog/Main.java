package com.renga.dog;

public class Main {
    public static void main(String[] args) {
        Dog pochi = new Dog("ポチ", 1, "柴犬", false);
        Dog chikuwa = new Dog("チクワ", 5, "チワワ", true);

        pochi.printProfile();
        pochi.bark();
        chikuwa.printProfile();
        chikuwa.bark();
    }
}
