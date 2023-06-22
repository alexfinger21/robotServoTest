// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.function.DoubleSupplier;

import java.lang.Math;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.servoCommand;
import frc.robot.subsystems.DriveSubsystem;

public class RobotContainer {

  private static XboxController mainController = new XboxController(0);

  private final DoubleSupplier leftX = () -> (mainController.getRawAxis(1));
  private final DoubleSupplier rightX = () -> (mainController.getRawAxis(5));

  //private final DoubleSupplier leftY = () -> (mainController.getRawAxis(1));

  private final DriveSubsystem driveSubsystem = new DriveSubsystem();
  private final servoCommand servoCommand = new servoCommand(driveSubsystem, leftX, rightX, mainController);

  

  public RobotContainer() {
    configureBindings();
    driveSubsystem.setDefaultCommand(servoCommand);
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return servoCommand;
  }
}
