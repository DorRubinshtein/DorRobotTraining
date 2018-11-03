package robot.collector;

import edu.wpi.first.wpilibj.command.Command;

public class CollectCube extends Command {

    private Collector m_Collector;

    public CollectCube(Collector collector){
        m_Collector = collector;
        requires(m_Collector);
    }

    @Override
    protected void execute() {
        m_Collector.setCollectorSpeed(-0.8);
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
