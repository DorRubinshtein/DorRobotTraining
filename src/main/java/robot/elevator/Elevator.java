package robot.elevator;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends Subsystem {

    private final ElevatorComponents m_ElevatorComponents;

    @Override
    protected void initDefaultCommand() { }

    public Elevator (ElevatorComponents ElevatorComponents){
        m_ElevatorComponents = ElevatorComponents;
    }

    public void setElevatorSpeed (final double speed){
        m_ElevatorComponents.getElevatorSpeedController().set(speed);
    }
}
