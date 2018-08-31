package frc.team6443.robot.hardware;

import edu.wpi.first.wpilibj.Encoder;

/**
 * Encoder class for 6443, contains some QOL code
 *
 * @author Lizzy M.
 * */
public class EncoderM extends Encoder {


    private int offset;

    public EncoderM(int channelA, int channelB) {
        super(channelA, channelB);
    }

    public EncoderM(int channelA, int channelB, int offset) {
        super(channelA, channelB, offset);
        this.offset = offset;
    }

    @Override
    public int get() {
        return super.get() + this.offset;
    }

    @Override
    public void reset() {
        super.reset();
        this.offset = 0;
    }

    public void set(int val) {
        super.reset();
        this.offset = val;
    }
}