package dev.alexandrevieira.advanced.c04_singleton;


class Singleton {
    public String str = "";

    private static Singleton instance = null;

    private Singleton() {

    }

    public static Singleton getSingleInstance() {
        if (instance == null) instance = new Singleton();

        return instance;
    }
}