package robot.driveTrain;

import edu.wpi.first.wpilibj.command.Command;

public class TurnWithoutPID extends Command {

    private DriveTrain m_driveTrain;
    private int m_degree;

    public TurnWithoutPID(DriveTrain driveTrain, int degree) {
        m_driveTrain = driveTrain;
        m_degree = degree;
        requires(m_driveTrain);
    }

    @Override
    protected void initialize() {
        m_driveTrain.resetNavX();
    }

    @Override
    protected void execute() {
        m_driveTrain.arcadeDrive(0, 0.7);
    }

    @Override
    protected boolean isFinished() {
        System.out.println(m_driveTrain.getNavXAngle());
        return m_driveTrain.getNavXAngle() > m_degree;
    }

    @Override
    protected void interrupted() {
        end();
    }

    @Override
    protected void end() {
        m_driveTrain.arcadeDrive(0, 0);
        m_driveTrain.resetNavX();
    }
}
