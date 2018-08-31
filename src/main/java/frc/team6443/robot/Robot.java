package frc.team6443.robot;

import edu.wpi.cscore.VideoMode;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.team6443.robot.commands.TeleopMode;
import frc.team6443.robot.commands.autonomies.CrossLine;
import frc.team6443.robot.subsystems.DriveTrainSystem;


/**
 * ROBOTS DON'T QUIT!
 * The Robot class is FRC team 6443's implementation of WPIlib's TimedRobot class.
 * TimedRobot is used as it offers a minor advantage of a consistent (20ms) loop time, assuming
 * you've written good code
 *
 * @author Christopher Medlin, Aleks Vidmantas
 */
public class Robot extends TimedRobot {

    // All the subsystems that the robot possesses
    // If a new subsystem is added, it must also be added to SimpleCommand.
    // From there the subsystem can be referred to from any command that inherits SimpleCommand.
    public static final DriveTrainSystem DriveTrain = new DriveTrainSystem();
    public static OI oi;

    private Command autonomy;
    private Command teleop;


    /* This code is ran ONCE when the robot is TURNED ON.  No code that requires enabling should be put here */
    @Override
    public void robotInit() {
        oi = new OI();
        autonomy = new CrossLine(6,.5,5);
        teleop = new TeleopMode();

        //format 1 is kMJPEG.  This will be viewable in shuffleboard.
        VideoMode vm = new VideoMode(1, 640, 480, 60);
        CameraServer.getInstance().startAutomaticCapture().setVideoMode(vm);
    }

    /*
     * Called when the robot first enters disabled mode.  Use this method to reset essential values.
     */
    @Override
    public void disabledInit() {
        Scheduler.getInstance().removeAll();
    }


    /*
     * Called periodically when the robot is in disabled mode.  The FPGA WILL stop the robot when this is
     * called, even if you don't explicitly stop the motors.
     */
    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().removeAll();
        //Scheduler.getInstance().run();
    }

    /*
     * Called when the robot first enters autonomous mode.
     */
    @Override
    public void autonomousInit() {
        if (autonomy != null) autonomy.start();
    }

    /*
     * Called periodically when the robot is in autonomous mode.
     */
    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    /*
     * Called when the robot first enter teleop mode.
     */
    @Override
    public void teleopInit() {
        if (autonomy != null) autonomy.cancel();
        if (teleop != null) teleop.start();
    }

    /*
     * Called periodically (20ms) when the robot is in teleop mode.
     */
    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }


}