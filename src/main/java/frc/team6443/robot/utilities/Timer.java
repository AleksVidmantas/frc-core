package frc.team6443.robot.utilities;

/**
 * Basic timer class for delaying commands without extending TimerTasks and stuff like that
 *
 * Simply do if(t.getElapsed > 1.4) to see if elapsed time is greater than 1.4 SECONDS
 *
 * This class has limited functionality and is aimed at autonomus for now
 *
 * @author Aleks Vidmantas
 * */
public class Timer {

    private long startTime;

    public Timer(){

    }

    public void start(){
        startTime = System.nanoTime();
    }

    public double getElapsed(){
        long elapsed = System.nanoTime() - startTime;
        return elapsed/1000000000.0;
    }
}
