package edu.iu.eebridge.ducksservice.model;

public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        //do nothing - can't quack!
    }
}
