package edu.iu.eebridge.ducksservice.model;

public class RedheadDuck extends Duck{
    public RedheadDuck(int id, DuckType type) {
        super(id, type);
    }

    @Override
    void display() {
        System.out.println("Looks like a redhead");
    }
}
