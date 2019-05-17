package io.github.marmagzzz.makepupp.timer;

import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;

public class TimeTaskManager {
    private Timer taskTimer;
    private int time, subTime;
    private boolean shouldContinue;
    private Thread thread;

    public TimeTaskManager(int intervalTime){

        thread = new Thread();
        this.taskTimer = new Timer();
        this.time = intervalTime;
        this.subTime = 0;
        this.shouldContinue = false;
    }

    public void start(final TimerInterface timerProgress, final Runnable assignedTask){
        this.shouldContinue = true;
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (shouldContinue){
                    try {
                        if(subTime <= time){
                            timerProgress.onGoing(subTime, time);
                            setProgress();
                        }
                        else{
                            assignedTask.run();
                            resetSubTime();
                        }
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                        timerProgress.onStop(e);
                        stop();
                    }
                }
            }
        });

        thread.start();

    }

    public void stop(){
        this.subTime = 0;
        this.shouldContinue = false;
    }

    public void resetSubTime(){
        this.subTime = 0;
    }

    public void setProgress() {
        this.subTime = this.subTime + 1000;
    }

    public double getProgress(){
//        return (this.subTime / this.time) * 100;
        return this.subTime;
    }

}
