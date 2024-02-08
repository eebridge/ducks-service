package edu.iu.eebridge.ducksservice.model;

public class MallardDuck extends Duck {
    public MallardDuck(int id, DuckType type) {
        super(id, type);
    }

    @Override
    void display() {
        System.out.println("Looks like a mallard");
    }
}
