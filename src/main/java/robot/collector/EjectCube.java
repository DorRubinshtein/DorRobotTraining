package robot.collector;

import edu.wpi.first.wpilibj.command.Command;

public class EjectCube extends Command {


    private Collector m_Collector;

    public EjectCube(Collector collector){
        m_Collector = collector;
        requires(m_Collector);
    }

    @Override
    protected void execute() {
        m_Collector.setCollectorSpeed(0.8);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void interrupted() {
        m_Collector.setCollectorSpeed(0);
    }
}
