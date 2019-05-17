package io.github.marmagzzz.makepupp.timer;

public interface TimerInterface {

    void onGoing(double progress, int intervalTime);
    void onStop(Exception e);

}
