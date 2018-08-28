package frc.team6443.robot.hardware;

import edu.wpi.first.wpilibj.Encoder;

/**
 * TODO: fix
 * named as so because the Encoder wpi class has a method that isn't named
 * appealingly
 * */
public class EncoderM {
    private Encoder encoder;

    public EncoderM(int channelA, int channelB) {
        encoder = new Encoder(channelA, channelB);
    }

    public double getDistance() {
        encoder.getDistance();

        return encoder.getRaw();
    }

    public void reset() {
        encoder.reset();
    }

    public void setReverseDirection(boolean reversed) {
        encoder.setReverseDirection(reversed);
    }
}