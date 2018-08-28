package frc.team6443.robot.commands;

import edu.wpi.first.wpilibj.GenericHID;
import frc.team6443.robot.OI;
import frc.team6443.robot.Robot;
import frc.team6443.robot.hardware.joysticks.Xbox;
import frc.team6443.robot.subsystems.DriveTrainSystem;

/**
 * Teleoperated mode for the robot.
 * The execute method of this class handles all possible inputs from the driver during the game.
 *
 * @author Aleks Vidmantas
 */
public class TeleopMode extends SimpleCommand {

    /* The philosophy of making these Xbox objects and not GenericHID is due to the need to find a balance
    * between easily readable code, easily reusable code, and easily replaced code.   */

    Xbox x1;
    Xbox x2;

    public TeleopMode() {
        super("Teleop Command");
        requires(driveTrain);

        //one compromise is newcommers may have trouble with casting
        //this is a simple enough concept, one of you can explain it.
        //plus it's covered in ap cs
        x1 = (Xbox)OI.getPrimaryControler(); //x1 isn't a copy of OI's controller, it IS the controller. Notice the casting
        x2 = (Xbox)OI.getSecondary();



    }

    @Override
    public void initialize() {

    }

    /* looped method, ran every 20ms*/
    @Override
    public void execute() {

        //shifting methods for speed control
        if(x1.rightBumper())
            Robot.DriveTrain.upShift();

        if(x1.leftBumper())
            Robot.DriveTrain.downShift();

        //this single line is in charge of controlling the entire drivetrain during teleop
        //noise filtration takes place in falconDrive()
        Robot.DriveTrain.falconDrive(x1.leftStickX(), x1.rightTrigger(), x1.leftTrigger());
    }

    public boolean isFinished() {
        return false;
    }
}