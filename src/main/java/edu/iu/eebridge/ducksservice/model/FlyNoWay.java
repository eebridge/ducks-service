package edu.iu.eebridge.ducksservice.model;

public class FlyNoWay implements FlyBehavior {
    private int speed = 0;

    @Override
    public int[] fly(int[] positionBefore) {
        int[] noFly = new int[2];
        return noFly;
    }
}