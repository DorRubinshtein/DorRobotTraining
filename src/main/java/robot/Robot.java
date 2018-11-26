package robot;

import edu.wpi.first.wpilibj.XboxController;
import robot.collector.BasicCollectorComponents;
import robot.collector.CollectCube;
import robot.collector.Collector;
import robot.collector.EjectCube;
import robot.driveTrain.BasicDriveTrainComponents;
import robot.driveTrain.DriveTrain;
import robot.driveTrain.TurnByNavX;
import robot.driveTrain.TurnWithoutPID;
import robot.elevator.Elevator;
import edu.wpi.first.wpilibj.TimedRobot;
import robot.elevator.*;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import robot.pitchElevator.BasicPitchElevatorComponents;
import robot.pitchElevator.PitchElevator;
import robot.pitchElevator.PitchElevatoreDown;
import robot.pitchElevator.PitchElevatoreUp;

public class Robot extends TimedRobot {

    DriveTrain driveTrain;
    @Override
    public void robotInit() {
        super.robotInit();
        final XboxController xboxController = new XboxController(0);
        driveTrain = new DriveTrain(new BasicDriveTrainComponents(), xboxController);
        final Elevator elevator = new Elevator(new BasicElevatorComponents());
        final Collector collector = new Collector(new BasicCollectorComponents());
        final PitchElevator pitchElevator = new PitchElevator(new BasicPitchElevatorComponents());
        final OI oi = new OI(
                xboxController,
                new Raise(elevator),
                new Lower(elevator),
                new EjectCube(collector),
                new CollectCube(collector),
                new TurnByNavX(driveTrain, 120),
                new TurnWithoutPID(driveTrain, 90),
                new PitchElevatoreUp(pitchElevator),
                new PitchElevatoreDown(pitchElevator));
    }

    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void testInit() {
        LiveWindow.setEnabled(true);
    }

    @Override
    public void disabledInit() {
        LiveWindow.setEnabled(false);
    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }
}
