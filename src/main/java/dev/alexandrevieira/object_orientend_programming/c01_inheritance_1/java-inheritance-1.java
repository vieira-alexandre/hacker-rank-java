package dev.alexandrevieira.object_orientend_programming.c01_inheritance_1;

class Animal {
    void walk() {
        System.out.println("I am walking");
    }
}

class Bird extends Animal {
    void sing() {
        System.out.println("I am singing");
    }

    void fly() {
        System.out.println("I am flying");
    }
}


class Solution {

    public static void main(String args[]) {

        Bird bird = new Bird();
        bird.walk();
        bird.fly();
        bird.sing();

    }
}
