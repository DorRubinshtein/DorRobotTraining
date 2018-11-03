package robot.collector;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.*;

public class BasicCollectorComponents implements CollectorComponents {

    private final SpeedController m_CollectorSpeedController;
    private final DoubleSolenoid CollectorSolenoid;
    private final DigitalInput BumperSwitch;

    @Override
    public SpeedController getCollectorSpeedController() {
        return m_CollectorSpeedController;
    }

    @Override
    public DoubleSolenoid getCollectorSolenoid() {
        return CollectorSolenoid;
    }

    @Override
    public DigitalInput getBumperSwitch() {
        return BumperSwitch;
    }

    public BasicCollectorComponents(){

        SpeedController LeftSpeedController = new WPI_VictorSPX(6);
        LeftSpeedController.setInverted(true);
        SpeedController RightSpeedController = new WPI_VictorSPX(7);
        m_CollectorSpeedController = new SpeedControllerGroup(LeftSpeedController, RightSpeedController);
        CollectorSolenoid = new DoubleSolenoid(7, 0);
        BumperSwitch = new DigitalInput(1);

    }
}
