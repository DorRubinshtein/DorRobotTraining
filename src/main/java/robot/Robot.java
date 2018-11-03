package robot;

import edu.wpi.first.wpilibj.XboxController;
import robot.collector.BasicCollectorComponents;
import robot.collector.CollectCube;
import robot.collector.Collector;
import robot.collector.EjectCube;
import robot.driveTrain.BasicDriveTrainComponents;
import robot.driveTrain.DriveTrain;
import robot.elevator.Elevator;
import edu.wpi.first.wpilibj.TimedRobot;
import robot.elevator.*;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Robot extends TimedRobot {

    @Override
    public void robotInit() {
        super.robotInit();
        final XboxController xboxController = new XboxController(0);
        final DriveTrain driveTrain = new DriveTrain(new BasicDriveTrainComponents(), xboxController);
        final Elevator elevator = new Elevator(new BasicElevatorComponents());
        final Collector collector = new Collector(new BasicCollectorComponents());
        final OI oi = new OI(xboxController, new Raise(elevator), new Lower(elevator), new EjectCube(collector), new CollectCube(collector));
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


}
