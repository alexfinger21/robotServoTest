package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class DriveSubsystem extends SubsystemBase {
    Servo servo = new Servo(0);
    Servo servo2 = new Servo(1);

    public DriveSubsystem() {

    }

    @Override
    public void periodic() {

    }

    public void moveServo(double degrees, double degrees2) {

        if (degrees > 0.4 && degrees < 0.6) {
            degrees = 0.5;
        }

        if (degrees2 > 0.4 && degrees2 < 0.6) {
            degrees2 = 0.5;
        }

        servo.set(degrees);
        servo2.set(1 - degrees2);
    }
}