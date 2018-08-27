package frc.team6443.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import frc.team6443.robot.hardware.joysticks.Xbox;


import java.util.HashMap;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 *
 * Binds controller so it can be referenced in programs
 *
 * In its current setup, two controllers exist in OI.  Ports go here instead of RobotMap
 * just because it's IO, not robot stuff.  The argument can be made for both places.
 *
 * @author Christopher Medlin
 */
public class OI {
    //computer ports, i.e. order Driver Station registers controllers
    private final int PRIMARY_PORT_NUMBER = 0;
    private final int SECONDARY_PORT_NUMBER = 1;

    //GenericHID for flexibility.  GenericHID offers methods
    //useful to us.  Xbox() is a 6443 class that extends GenericHID.  Also allows swappability.
    private static GenericHID primary;
    private static GenericHID secondary;

    private HashMap<String, Button> buttons;

    /**
     * Constructor for OI.
     */
    public OI() {
        primary = new Xbox(new XboxController(PRIMARY_PORT_NUMBER));
        secondary = new Xbox(new XboxController(SECONDARY_PORT_NUMBER));
        buttons = new HashMap<String, Button>(4);
    }

    /**
     * @return the primary Joystick associated with this OI object.
     */
    public static GenericHID getPrimaryControler(){
        return primary;
    }

    /**
     * @return the secondary Joystick associated with this OI object.
     */
    public static GenericHID getSecondary(){
        return secondary;
    }

    /**
     * Returns the Button object associated with the key.
     *
     * @param key the name of the button.
     * @return the button associated with the key.
     */
    public Button getButton(String key) {
        return buttons.get(key);
    }
}
