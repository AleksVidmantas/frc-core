package frc.team6443.robot.hardware;

import edu.wpi.first.wpilibj.DigitalInput;
/**
 * LimitSwitch class for limit switches.  Essentially a clearer interpretation
 * of the DigitalInput class *specifically* for LimiitSwitches.
 * */
public class LimitSwitch {
    private DigitalInput limit;

    public LimitSwitch(int channel){
        limit = new DigitalInput(channel);
    }

    public boolean get() {
        return limit.get(); //TODO: use to be !limit.get(), por que?
    }
}
