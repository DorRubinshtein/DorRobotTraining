package robot.driveTrain;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
    private final DriveTrainComponents m_components;
    private final XboxController m_xboxController;

    public DriveTrain(final DriveTrainComponents driveTrainComponents,
                      final XboxController xboxController) {
        m_components = driveTrainComponents;
        m_xboxController = xboxController;
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new DriveBySpeed(this, () -> m_xboxController.getY(GenericHID.Hand.kLeft),
                () -> m_xboxController.getX(GenericHID.Hand.kRight)));
    }

    public void arcadeDrive(final double forwardSpeed, final double rotationSpeed) {
        m_components.getDifferentialDrive().arcadeDrive(forwardSpeed, rotationSpeed);
    }

    public void resetNavX(){
        m_components.getNavX().reset();
    }

    public double getNavXAngle(){
        return m_components.getNavX().getAngle();
    }

    public void resetPIDControllers(){
        m_components.getRightPIDController().reset();
        m_components.getLeftPIDController().reset();
    }

    public void setSetPointPIDControllers(double m_degree){
        m_components.getRightPIDController().setSetpoint(m_degree);
        m_components.getLeftPIDController().setSetpoint(m_degree);
    }

    public void enablePIDControllers() {
        m_components.getRightPIDController().enable();
        m_components.getLeftPIDController().enable();
    }

    public boolean turningControllerOnTarget(){
        if (m_components.getRightPIDController().onTarget() && m_components.getLeftPIDController().onTarget() && !m_components.getNavX().isMoving() )
            return true;
        return false;
    }

    public void disablePIDControllers() {
        m_components.getRightPIDController().disable();
        m_components.getLeftPIDController().disable();
    }

}