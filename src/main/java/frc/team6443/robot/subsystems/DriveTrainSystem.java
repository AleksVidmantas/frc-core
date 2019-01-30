package frc.team6443.robot.subsystems;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.Vector2d;
import frc.team6443.robot.RobotMap;
import frc.team6443.robot.hardware.EncoderM;

/**
 * Subsystem for the robot's drive train.
 * <p>
 * Contains 2 SpeedControllerGroups which are controlled by an instance of RobotDrive.
 * This class is meant to fix some of the shortcomings of the original DriveTrainSystem
 * class as well as make it more simple and readable.
 *
 * @author Christopher Medlin, Ivan Kenevich, Shivashriganesh Mahato
 */
public class DriveTrainSystem extends Subsystem {

    private SpeedControllerGroup leftMotors;
    private SpeedControllerGroup rightMotors;

    private EncoderM leftEncoder;
    private EncoderM rightEncoder;

    private boolean reversed;
    private static final double WheelDiameter = 6;

    // A [nice] class in the wpilib that provides numerous driving capabilities.
    // Use it whenever you want your robot to move.
    private DifferentialDrive drive;


    /**
     * Constructor for DriveTrainSystem.
     */
    public DriveTrainSystem() {

        leftMotors = new SpeedControllerGroup(new Spark(RobotMap.FrontLeftMotor),
                new Spark(RobotMap.BackLeftMotor));
        rightMotors = new SpeedControllerGroup(new Spark(RobotMap.FrontRightMotor),
                new Spark(RobotMap.BackRightMotor));

        drive = new DifferentialDrive(leftMotors, rightMotors);

        leftMotors.setInverted(true);

        leftEncoder = new EncoderM(RobotMap.LeftEncoderA, RobotMap.LeftEncoderB);
        rightEncoder = new EncoderM(RobotMap.RightEncoderA, RobotMap.RightEncoderB);

        //motor watchdog, essentially call set(speed) whenever you want it on, else it'll shut off
        drive.setSafetyEnabled(true);

        reversed = false;
        //drive.setMaxOutput(.44); for demos, PLEASE of all that is holy limit HERE
    }

    @Override
    public void initDefaultCommand() { }

    /**
     * Allows for custom setting of motor power level.
     *
     * @param left  the power for the left motors.
     * @param right the power for the right motors.
     */
    public void tankDrive(double left, double right) {
        if (reversed) {
            drive.tankDrive(-left, -right);
        } else {
            drive.tankDrive(left, right);
        }
    }

    /**
     * Allows for custom setting of motor power level across both sides.
     *
     * @param speed  the power for the motors.
     */
    public void tankDrive(double speed){
        if(reversed){
            drive.tankDrive(-speed, -speed);
        }else{//TODO examine spacing standard
            drive.tankDrive(speed, speed);
        }
    }

    /**
     * Toggles the motors to go in reverse.
     */
    public void reverse() {
        reversed = !reversed;
    }

    public boolean isReversed() {
        return reversed;
    }

    public double getLeftDistance(){
        // EncoderM clicks per rotation = 850
        return leftEncoder.getDistance() * WheelDiameter * Math.PI / 850; // In inches
    }

    public double getRightDistance(){
        return rightEncoder.getDistance() * WheelDiameter * Math.PI / 850; // In inches
    }

    //FIND A BETTER WAY!!!
    public double getLinearDistance(){
        return (getLeftDistance() + getRightDistance()) / 2;
    }

    public void reset(){
        leftEncoder.reset();
        rightEncoder.reset();
    }

    //this data is only used for falconDrive
    private boolean shifted = false;
    private double differential;
    private double power;

    public void upShift(){ shifted = true;}
    public void downShift(){shifted = false;}

    private double leftPwr;
    private double rightPwr;

    public void falconDrive(double leftStickX, double rightTrigger, double leftTrigger) {
        Vector2d vector = new Vector2d(0,0);
        rightPwr = 0;
        leftPwr = 0;
        power = 1;

        if (Math.abs(leftStickX) < .15) {
            differential = 0;
        } else {
            differential = Math.abs(leftStickX);
        }
        if(!shifted){ power = .7; }

        if (rightTrigger > 0) {//forward
            rightPwr = rightTrigger*power+.1 - Math.pow(Math.E,-rightTrigger)*.5*differential*Math.signum(leftStickX)*-1;
            leftPwr = rightTrigger*power+.1 - Math.pow(Math.E,-rightTrigger)*.5*differential*Math.signum(leftStickX);
            rightPwr *= -1;
            leftPwr *= -1;

        } else if (leftTrigger > 0) { //reverse
            rightPwr = leftTrigger*power+.1 - Math.pow(Math.E,-leftTrigger)*.5*differential*Math.signum(leftStickX);
            leftPwr = leftTrigger*power+.1 - Math.pow(Math.E,-leftTrigger)*.5*differential*Math.signum(leftStickX)*-1;

        } else { //no trigger values, stationary rotation
            if(Math.abs(leftStickX) > .2){
                rightPwr = -leftStickX/1.28-(.1*Math.signum(leftStickX));
                leftPwr = leftStickX/1.28+(.1*Math.signum(leftStickX));
            }
        }

        tankDrive(leftPwr, rightPwr);
    }
}
