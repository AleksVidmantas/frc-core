package frc.team6443.robot.hardware;

import edu.wpi.first.wpilibj.DigitalInput;
/**
 * LimitSwitch class for limit switches.  Essentially a clearer interpretation
 * of the DigitalInput class *specifically* for LimitSwitches.
 * */
public class LimitSwitch extends DigitalInput{

    public LimitSwitch(int channel){
        super(channel);
    }

    public boolean get() {
        return get(); //TODO: use to be !limit.get(), por que?
    }
}
