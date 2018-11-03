package robot.elevator;

import edu.wpi.first.wpilibj.command.Command;

public class Raise extends Command {

    private Elevator m_Elevator;

    public Raise(Elevator elevator){
        m_Elevator = elevator;
        requires(m_Elevator);
    }

    @Override
    protected void execute() {
        m_Elevator.setElevatorSpeed(0.8);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void interrupted() {
        m_Elevator.setElevatorSpeed(0);
    }
}
