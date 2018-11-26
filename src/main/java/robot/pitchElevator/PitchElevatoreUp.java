package robot.pitchElevator;

import edu.wpi.first.wpilibj.command.Command;

public class PitchElevatoreUp extends Command {

    private final PitchElevator m_pitchElevator;


    public PitchElevatoreUp(PitchElevator pitchElevator){
        m_pitchElevator = pitchElevator;
    }

    @Override
    protected void execute() {
        m_pitchElevator.setPitchSpeed(0.8);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void interrupted() {
        m_pitchElevator.setPitchSpeed(0);
    }
}
