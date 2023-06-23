package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


public class DriveSubsystem extends SubsystemBase {
    CANSparkMax motor1 = new CANSparkMax(0, MotorType.kBrushless);
    CANSparkMax motor2 = new CANSparkMax(1, MotorType.kBrushless);
    DifferentialDrive diffDrive = new DifferentialDrive(motor1, motor2);

    public DriveSubsystem() {

    }

    @Override
    public void periodic() {

    }

    public void driveRobot(double degrees, double degrees2) {

        diffDrive.tankDrive(Math.pow(degrees, 3), Math.pow(degrees2, 3));
    }
}