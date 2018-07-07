package frc.team6443.robot.commands;

import edu.wpi.first.wpilibj.GenericHID;
import frc.team6443.robot.Robot;
import frc.team6443.robot.hardware.joysticks.Xbox;

/**
 * Teleoperated mode for the robot.
 * The execute method of this class handles all possible inputs from the driver during the game.
 *
 * @author Ivan Kenevich, Christopher Medlin, Shivashriganesh Mahato
 */
public class TeleopMode extends SimpleCommand {


    public TeleopMode() {
        super("Teleop Command");
        requires(driveTrain);

    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {

    }

    public boolean isFinished() {
        return false;
    }
}