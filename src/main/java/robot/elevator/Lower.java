package robot.elevator;

import edu.wpi.first.wpilibj.command.Command;

public class Lower extends Command {

    private Elevator m_Elevator;

    public Lower(Elevator elevator){
        m_Elevator = elevator;
        requires(m_Elevator);
    }

    @Override
    protected void execute() {
        m_Elevator.setElevatorSpeed(-0.4);
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
