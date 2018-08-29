package frc.team6443.robot.hardware;

import edu.wpi.first.wpilibj.Encoder;

/**
 * TODO: fix
 * named as so because the Encoder wpi class has a method that isn't named
 * appealingly
 * */
public class EncoderM extends Encoder {


    public EncoderM(int channelA, int channelB) {
        super(channelA,channelB);
    }

    public double getDistance() {
        getDistance();

        return getRaw();
    }

    public void reset() {
        reset();
    }

    public void setReverseDirection(boolean reversed) {
        setReverseDirection(reversed);
    }
}