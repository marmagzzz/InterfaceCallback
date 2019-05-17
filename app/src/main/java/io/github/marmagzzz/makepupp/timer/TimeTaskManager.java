package io.github.marmagzzz.makepupp.timer;

import android.util.Log;
import io.github.marmagzzz.makepupp.my_interface.TimerInterface;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;

public class TimeTaskManager {
    private Timer taskTimer;
    private int time, subTime;
    private boolean shouldContinue;
    private Thread thread;

    public TimeTaskManager(){

        thread = new Thread();
        this.taskTimer = new Timer();
        this.time = 10000;
        this.subTime = 0;
        this.shouldContinue = false;
    }

    public void start(final timerProgress timerProgress, final Runnable assignedTask){
        this.shouldContinue = true;
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (subTime <= time && shouldContinue){
                    try {
                        timerProgress.onGoing(getProgress());
                        if(subTime != time){
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

    public int getProgress(){
        return (this.subTime / this.time) * 100;
    }

    public interface timerProgress {
        void onGoing(int progress);
        void onStop(Exception e);
    }

}
