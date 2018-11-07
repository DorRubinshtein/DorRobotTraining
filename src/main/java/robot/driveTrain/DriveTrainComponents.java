package robot.driveTrain;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public interface DriveTrainComponents {
    SpeedController getLeftSpeedController();

    SpeedController getRightSpeedController();

    DifferentialDrive getDifferentialDrive();

    AHRS getNavX();
}
