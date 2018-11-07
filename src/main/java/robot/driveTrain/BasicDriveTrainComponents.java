package robot.driveTrain;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class BasicDriveTrainComponents implements DriveTrainComponents {
    private final SpeedController m_leftSpeedController;
    private final SpeedController m_rightSpeedController;
    private final DifferentialDrive m_differentialDrive;
    private final AHRS m_NavX;


    public BasicDriveTrainComponents() {
        SpeedController firstLeftSpeedController = new WPI_TalonSRX(0);
        SpeedController secondLeftSpeedController = new WPI_TalonSRX(1);
        m_leftSpeedController = new SpeedControllerGroup(firstLeftSpeedController, secondLeftSpeedController);
        SpeedController firstRightSpeedController = new WPI_TalonSRX(2);
        SpeedController secondRightSpeedController = new WPI_TalonSRX(3);
        m_rightSpeedController = new SpeedControllerGroup(firstRightSpeedController, secondRightSpeedController);
        m_differentialDrive = new DifferentialDrive(m_leftSpeedController, m_rightSpeedController);
        m_NavX = new AHRS(SPI.Port.kMXP);
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

    @Override
    public AHRS getNavX() {
        return m_NavX;
    }
}
