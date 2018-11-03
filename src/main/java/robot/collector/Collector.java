package robot.collector;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Collector extends Subsystem {

    CollectorComponents m_CollectorComponents;

    public Collector (CollectorComponents collectorComponents){
        m_CollectorComponents = collectorComponents;
    }

    public void setCollectorSpeed(final double speed){
        m_CollectorComponents.getCollectorSpeedController().set(speed);
    }

    public void openClaw(){
        m_CollectorComponents.getCollectorSolenoid().set(DoubleSolenoid.Value.kReverse);
    }

    public void closeClaw(){
        m_CollectorComponents.getCollectorSolenoid().set(DoubleSolenoid.Value.kForward);
    }

    @Override
    protected void initDefaultCommand() { }
}
