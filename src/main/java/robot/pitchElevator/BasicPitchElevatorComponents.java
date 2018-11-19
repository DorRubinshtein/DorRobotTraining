package robot.pitchElevator;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.SpeedController;

public class BasicPitchElevatorComponents implements PitchElevatorComponents {


    private final WPI_TalonSRX MainSpeedController;
    //private final SpeedController ClawSpeedController;

    @Override
    public WPI_TalonSRX getMainSpeedController() {
        return MainSpeedController;
    }

    //@Override
    //public SpeedController getClawSpeedController() {
    //    return ClawSpeedController;
    //}

    public BasicPitchElevatorComponents(){

        MainSpeedController = new WPI_TalonSRX(28);
        //ClawSpeedController = new WPI_VictorSPX(29);
    }
}
