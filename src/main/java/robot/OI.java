package robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import robot.collector.CollectCube;
import robot.collector.Collector;
import robot.collector.EjectCube;
import robot.driveTrain.TurnByNavX;
import robot.driveTrain.TurnWithoutPID;
import robot.elevator.Lower;
import robot.elevator.Raise;

public class OI {
    public OI(XboxController xboxController,
              Raise raiseElevator,
              Lower lowerElevator,
              EjectCube eject,
              CollectCube collectCube,
              TurnByNavX turnByNavX,
              TurnWithoutPID turnWithoutPID) {
        JoystickButton raiseElevatorButton = new JoystickButton(xboxController, 4);
        raiseElevatorButton.whileHeld(raiseElevator);
        JoystickButton lowerElevatorButton = new JoystickButton(xboxController, 1);
        lowerElevatorButton.whileHeld(lowerElevator);
        JoystickButton ejectButton = new JoystickButton(xboxController, 2);
        ejectButton.whileHeld(eject);
        JoystickButton collectButton = new JoystickButton(xboxController, 3);
        collectButton.whileHeld(collectCube);
        JoystickButton turnByNavXButton = new JoystickButton(xboxController, 5);
        turnByNavXButton.whenPressed(turnByNavX);
        JoystickButton turnWithoutPIDButton = new JoystickButton(xboxController, 6);
        turnWithoutPIDButton.whenPressed(turnWithoutPID);
    }
}