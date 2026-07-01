package frc.robot.subsystems.shooter;

import com.ctre.phoenix6.configs.*;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.revrobotics.servohub.ServoChannel;
import com.revrobotics.servohub.config.ServoChannelConfig;
import com.revrobotics.servohub.config.ServoHubConfig;

import static edu.wpi.first.units.Units.RPM;
import static edu.wpi.first.units.Units.RotationsPerSecond;

public class ShooterConstants {
    public static final int SHOOTER_LEFT_ID = 18;
    public static final int SHOOTER_MIDDLE_ID = 19;
    public static final int SHOOTER_RIGHT_ID = 20;
    public static final int SERVO_HUB_ID = 21;
}
