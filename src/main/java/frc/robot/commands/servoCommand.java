package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.PS4Controller.Button;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;

public class servoCommand extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final DriveSubsystem m_Subsystem;
    private final DoubleSupplier leftX;
    private final DoubleSupplier rightX;
    private final XboxController controller;
    public servoCommand(DriveSubsystem subsystem, DoubleSupplier leftyX, DoubleSupplier rightyX, XboxController controlly) {
        m_Subsystem = subsystem;
        leftX = leftyX;
        rightX = rightyX;
        controller = controlly;

        addRequirements(subsystem);
    }

    @Override
  public void initialize() {
    System.out.println("Starting joystick drive");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //System.out.println(controller.getYButtonPressed());
    //if (controller.getYButton()) {
        SmartDashboard.putNumber("joy1", leftX.getAsDouble());
        SmartDashboard.putNumber("joy2", rightX.getAsDouble());
        m_Subsystem.driveRobot((double) (leftX.getAsDouble()), (double) (rightX.getAsDouble()));
    //}
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
