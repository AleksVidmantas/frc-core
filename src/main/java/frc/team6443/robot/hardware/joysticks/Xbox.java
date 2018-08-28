package frc.team6443.robot.hardware.joysticks;

import edu.wpi.first.wpilibj.XboxController;


/**
 * Recreation of WPI's Xbox class.  This version is much easier to use.  Essentially still a GenericHID object.
 *
 * @author Patrick Higgins, Aleks Vidmantas
 */
public class Xbox extends XboxController {  //extends GenericHID for flexibility

    /**
     * Constructor for Xbox.
     *
     *
     */
    public Xbox(int PORT) {
        super(PORT);
    }


    public XboxController getJoystick(XboxController xbox) {
        return xbox;
    }



    public double leftStickX() {
        //return getY(Hand.kLeft); alternative soluton
        return getRawAxis(0);
    }

    /**
     * @return The value of the Y axis of the left stick.
     */
    public double leftStickY() {
        return getRawAxis(1);
    }

    /**
     * @return The value of the X axis of the right stick.
     */
    public double rightStickX() {
        return getRawAxis(4);
    }

    /**
     * @return The value of the Y axis of the right stick.
     */
    public double rightStickY() {
        return getRawAxis(5);
    }

    /**
     * @return The value of the axis for the left trigger.
     */
    public double leftTrigger() {
        return getRawAxis(2);
    }

    /**
     * @return The value of the axis for the right trigger.
     */
    public double rightTrigger() {
        return getRawAxis(3);
    }

    /**
     * @return the value of the left bumper.
     */
    public boolean leftBumper() {
        return getRawButton(5);
    }

    /**
     * @return the value of the right bumper.
     */
    public boolean rightBumper() {
        return getRawButton(6);
    }

    /**
     * @return the value of the left joystick button.
     */
    public boolean leftStickButton() {
        return getRawButton(9);
    }

    /**
     * @return the value of the right joystick button.
     */
    public boolean rightStickButton() {
        return getRawButton(10);
    }

    /**
     * @return the value of the A button.
     */
    public boolean A() {
        return getRawButton(1);
    }

    /**
     * @return the value of the B button.
     */
    public boolean B() {
        return getRawButton(2);
    }

    /**
     * @return the value of the X button.
     */
    public boolean X() {
        return getRawButton(3);
    }

    /**
     * @return the value of the Y button.
     */
    public boolean Y() {
        return getRawButton(4);
    }

    //PLEASE FIND THE ACTUAL NAME FOR THESE
    public boolean seven() {
        return getRawButton(7);
    }
    public boolean eight() {
        return getRawButton(8);
    }

    public void setRumble(boolean isLeft, float strength){
        RumbleType rumbleSide = (isLeft) ? RumbleType.kLeftRumble : RumbleType.kRightRumble;
        setRumble(rumbleSide, strength);
    }

    public void killRumble(){
        setRumble(RumbleType.kLeftRumble, 0);
        setRumble(RumbleType.kRightRumble, 0);
    }


    @Override
    public double getX(Hand hand) {
        return 0;
    }

    @Override
    public double getY(Hand hand) {
        return 0;
    }


    //not required, as falconDrive has it's own filtration system for noise zones
    public static double reduceNoise(double x){
        if(Math.abs(x) < .2){
            return 0;
        }else{
            return x;
        }
    }
}
