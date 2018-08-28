package frc.team6443.robot.commands;

import frc.team6443.robot.OI;
import frc.team6443.robot.Robot;
import frc.team6443.robot.hardware.joysticks.Xbox;

/**
 * Teleoperated mode for the robot.
 * The execute method of this class handles all possible inputs from the driver during the game.
 *
 * @author Aleks Vidmantas
 */
public class TeleopMode extends SimpleCommand {

    Xbox x1;
    Xbox x2;

    public TeleopMode() {

        super("Teleop Command");
        requires(driveTrain);

        x1 = (Xbox)OI.getPrimary(); //x1 isn't a copy of OI's controller, it IS the controller. Notice the casting
        x2 = (Xbox)OI.getSecondary();



    }

    @Override
    public void initialize() {

    }

    @Override /* looped method, ran every 20ms*/
    public void execute() {

        //shifting methods for speed control
        if(x1.rightBumper())
            Robot.DriveTrain.upShift();

        if(x1.leftBumper())
            Robot.DriveTrain.downShift();

        //this single line is in charge of controlling the entire drivetrain during teleop
        Robot.DriveTrain.falconDrive(x1.leftStickX(), x1.rightTrigger(), x1.leftTrigger());
    }

    public boolean isFinished() {
        return false;
    }
}