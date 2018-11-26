package robot.pitchElevator;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;

public class PitchElevator extends Subsystem {

    private final BasicPitchElevatorComponents m_PitchElevatorComponents;

    public PitchElevator(BasicPitchElevatorComponents pitchElevatorComponents){
        m_PitchElevatorComponents = pitchElevatorComponents;
    }

    @Override
    protected void initDefaultCommand() {

    }

    public int getEncoderValue(){
        return m_PitchElevatorComponents.getMainSpeedController().getSensorCollection().getQuadraturePosition();
    }

    public void setPitchSpeed(double speed){
        m_PitchElevatorComponents.getMainSpeedController().set(speed);
    }

    public void setPitchPosition(int encoderPoints){
        m_PitchElevatorComponents.getMainSpeedController().set(ControlMode.Position, encoderPoints);
    }
}
