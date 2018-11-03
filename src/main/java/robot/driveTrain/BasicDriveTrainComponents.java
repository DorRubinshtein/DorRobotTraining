package robot.driveTrain;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class BasicDriveTrainComponents implements DriveTrainComponents {
    private static final double WHEEL_RADIUS_INCHES = 2;
    private static final double CENTIMETERS_IN_INCH = 2.54;
    private static final double COUNTS_PER_ROUND = 200;
    private final SpeedController m_leftSpeedController;
    private final SpeedController m_rightSpeedController;
    private final DifferentialDrive m_differentialDrive;
    private final Encoder m_leftEncoder;
    private final Encoder m_rightEncoder;

    public BasicDriveTrainComponents() {
        SpeedController firstLeftSpeedController = new WPI_TalonSRX(0);
        SpeedController secondLeftSpeedController = new WPI_TalonSRX(1);
        m_leftSpeedController = new SpeedControllerGroup(firstLeftSpeedController, secondLeftSpeedController);
        SpeedController firstRightSpeedController = new WPI_TalonSRX(2);
        SpeedController secondRightSpeedController = new WPI_TalonSRX(3);
        m_rightSpeedController = new SpeedControllerGroup(firstRightSpeedController, secondRightSpeedController);
        m_differentialDrive = new DifferentialDrive(m_leftSpeedController, m_rightSpeedController);

        double encoderDistancePerPulse = GetCirclePerimeter(WHEEL_RADIUS_INCHES * CENTIMETERS_IN_INCH) / COUNTS_PER_ROUND;
        m_leftEncoder = new Encoder(0, 1);
        m_leftEncoder.setDistancePerPulse(encoderDistancePerPulse);
        m_rightEncoder = new Encoder(2, 3);
        m_rightEncoder.setDistancePerPulse(encoderDistancePerPulse);
    }

    private double GetCirclePerimeter(double circleRadius) {
        return 2 * Math.PI * circleRadius;
    }

    @Override
    public SpeedController getLeftSpeedController() {
        return m_leftSpeedController;
    }

    @Override
    public SpeedController getRightSpeedController() {
        return m_rightSpeedController;
    }

    @Override
    public DifferentialDrive getDifferentialDrive() {
        return m_differentialDrive;
    }
}
