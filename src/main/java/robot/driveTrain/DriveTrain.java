package robot.driveTrain;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.GenericHID;
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

    public AHRS getNavX(){
        return m_components.getNavX();
    }
}