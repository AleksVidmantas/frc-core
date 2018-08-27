package frc.team6443.robot.commands;

import edu.wpi.first.wpilibj.GenericHID;
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

    /* The philosophy of making these Xbox objects and not GenericHID is due to the need to find a balance
    * between easily readable code, easily reusable code, and easily replaced code.  OI.java is almost a concrete
    * class, and should rarely need to be changed.  TeleopMode code however is more flexible, and can be hotswapped.
    * the main struggle comes from needing GenericHID methods while also wanting readable methods from Xbox.java
    * by making all of the controller code (that needs to be switched) centered in TeleopMode, OI can remain safe.
    * In addition, if the controller type was changed (Xbox to Playstation) the methods called in execute() such
    * as getX() would need to be changed *anyways*.  Due to this sole reason is why ((Xbox)OI.getPrimary).getX()
     * isn't in place. This is hella unreadable. The Xbox casting method would mean x1 and x2 can remain GenericHID (You lose access to
     * Xbox methods like getX() [it's simpler is why it's a bad thing to lose them]).  This is good for swapping
     * (but gross for testing).  The current method accepts that perfection can't be achieved and finds a balance.
      * due the nature of needing to switch getX() to getButton(n)
      *
      *  */

    Xbox x1;
    Xbox x2;

    public TeleopMode() {
        super("Teleop Command");
        requires(driveTrain);
        x1 = (Xbox)OI.getPrimaryControler(); //x1 isn't a copy of OI's controller, it IS the controller. Notice the casting
        x2 = (Xbox)OI.getSecondary();

    }

    @Override
    public void initialize() {

    }

    /* looped method, ran every 20ms*/
    @Override
    public void execute() {
        if(x1.X()){
            //do function
        }

        if(Math.abs(x1.leftTrigger()) > .2){//-.2 - .2 is the controllers dead/noise zone.
            Robot.DriveTrain.falconDrive(x1.leftStickX());
        }
    }

    public boolean isFinished() {
        return false;
    }
}