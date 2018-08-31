package frc.team6443.robot.commands.autonomies;

import frc.team6443.robot.commands.SimpleCommand;
import frc.team6443.robot.utilities.Timer;

/**
 * @author Aleks Vidmantas
 *
 * This class is useful for crossing the line at the start of the match for the designated points.
 * A delay is also possible.
 *
 * Take note of the constructor options.
 *
 * DURATION and DELAY are set in SECONDS
 * speed is the 0-1 scale the drivetrain uses
 */
public class CrossLine extends SimpleCommand {

    private double duration;
    private double speed;
    private double delay;
    private Timer timer;
    private boolean go;


    public CrossLine(double duration){
        this(duration, .5);
    }


    public CrossLine(double duration, double speed) {
        this(duration, speed, 0);
    }


    public CrossLine(double duration, double speed, double delay){
        super("CrossLine for " + duration + " at speed: " + speed);
        this.duration = duration;
        this.speed = speed;
        this.delay = delay;
        timer = new Timer();
    }

    public void initialize(){
        timer.start();

        //in initialize to handle delays of 0
        go = timer.getElapsed() >= delay;

        setTimeout(duration);
    }

    public void execute(){
        if(timer.getElapsed() >= delay)
            go = true; //checks if go has become true

        if(go) driveTrain.tankDrive(speed);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }


}
