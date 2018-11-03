package robot.pitchElevator;

import edu.wpi.first.wpilibj.SpeedController;

public interface PitchElevatorComponents {

    SpeedController getMainSpeedController(); // The speed controller that is on the elevator axis.
    SpeedController getClawSpeedController(); // The speed controller that controls the claw movement.

}
