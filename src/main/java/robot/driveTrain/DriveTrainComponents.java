package robot.driveTrain;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public interface DriveTrainComponents {
    SpeedController getLeftSpeedController();

    SpeedController getRightSpeedController();

    DifferentialDrive getDifferentialDrive();

}
