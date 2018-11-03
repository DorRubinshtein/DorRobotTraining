package robot.collector;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;

public interface CollectorComponents {

    SpeedController getCollectorSpeedController();
    DoubleSolenoid getCollectorSolenoid();
    DigitalInput getBumperSwitch();

}
