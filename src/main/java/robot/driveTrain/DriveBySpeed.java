package robot.driveTrain;

import edu.wpi.first.wpilibj.command.Command;

import java.util.function.Supplier;

public class DriveBySpeed extends Command {
    private final Supplier<Number> m_forwardSpeedCalculation;
    private final Supplier<Number> m_rotationSpeedCalculation;
    private DriveTrain m_driveTrain;

    public DriveBySpeed(DriveTrain driveTrain, Supplier<Number> forwardSpeedCalculation,
                        Supplier<Number> rotationSpeedCalculation) {
        m_driveTrain = driveTrain;
        m_forwardSpeedCalculation = forwardSpeedCalculation;
        m_rotationSpeedCalculation = rotationSpeedCalculation;
        requires(m_driveTrain);
    }

    @Override
    public void execute() {

        double forwardSpeed = m_forwardSpeedCalculation.get().doubleValue();
        double rotationSpeed = m_rotationSpeedCalculation.get().doubleValue();
        m_driveTrain.arcadeDrive(forwardSpeed, rotationSpeed);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}
