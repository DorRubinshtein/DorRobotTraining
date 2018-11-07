package robot.driveTrain;

import edu.wpi.first.wpilibj.command.Command;

public class TurnByNavX extends Command {

    private DriveTrain m_driveTrain;
    private int m_degree;

    public TurnByNavX(DriveTrain driveTrain, int degree){
        m_driveTrain = driveTrain;
        m_degree = degree;
        requires(m_driveTrain);
    }

    @Override
    protected void initialize() {
        m_driveTrain.getNavX().reset();
    }

    @Override
    protected void execute() {
        m_driveTrain.arcadeDrive(0,1);
    }

    @Override
    protected boolean isFinished() {
        return m_driveTrain.getNavX().getAngle() == m_degree;
    }

    @Override
    protected void interrupted() {
        end();
    }

    @Override
    protected void end() {
        m_driveTrain.arcadeDrive(0,0);
    }
}
