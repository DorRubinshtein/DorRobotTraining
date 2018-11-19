package robot.pitchElevator;

import edu.wpi.first.wpilibj.command.Command;

public class PitchElevatoreDown extends Command {

    private final PitchElevator m_pitchElevator;


    public PitchElevatoreDown(PitchElevator pitchElevator){
        m_pitchElevator = pitchElevator;
    }

    @Override
    protected void execute() {
        m_pitchElevator.setPitchSpeed(-0.8);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}

