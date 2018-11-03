package robot.elevator;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class BasicElevatorComponents implements ElevatorComponents {

    private final SpeedController m_ElevatorSpeedController;

    @Override
    public SpeedController getElevatorSpeedController() {
        return m_ElevatorSpeedController;
    }

    public BasicElevatorComponents(){

        SpeedController firstSpeedController = new WPI_TalonSRX(8);
        SpeedController secondSpeedController = new WPI_VictorSPX(10);
        SpeedController thirdSpeedController = new WPI_VictorSPX(9);
        SpeedController fourthSpeedController = new WPI_VictorSPX(11);
        m_ElevatorSpeedController = new SpeedControllerGroup(firstSpeedController,secondSpeedController,thirdSpeedController,fourthSpeedController);
    }
}
