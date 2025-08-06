package com.renga.dog;

public class Dog {
    String name;
    int age;
    String breed;
    boolean isHungry;

    public Dog(String name, int age, String breed, boolean isHungry) {
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.isHungry = isHungry;
    }

    void bark () {
        if (isHungry){
            System.out.println("クゥーン");
        } else {
            System.out.println("ワン!");
        }
    }
    void printProfile(){
        System.out.println("名前:" + name +
                " 犬種:" + breed + "  年齢:" + age + "才");
    }
}
