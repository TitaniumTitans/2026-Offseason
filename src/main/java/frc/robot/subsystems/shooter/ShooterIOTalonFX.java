package frc.robot.subsystems.shooter;

import static edu.wpi.first.units.Units.RPM;
import static edu.wpi.first.units.Units.RotationsPerSecond;

import com.ctre.phoenix6.configs.*;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import frc.robot.Constants;

public class ShooterIOTalonFX implements ShooterIO {

  private final TalonFX shooterMotorLeft;
  private final TalonFX shooterMotorMiddle;
  private final TalonFX shooterMotorRight;

  public ShooterIOTalonFX() {

    shooterMotorLeft = new TalonFX(ShooterConstants.SHOOTER_LEFT_ID, Constants.CANIVORE_BUS);
    shooterMotorMiddle = new TalonFX(ShooterConstants.SHOOTER_MIDDLE_ID, Constants.CANIVORE_BUS);
    shooterMotorRight = new TalonFX(ShooterConstants.SHOOTER_RIGHT_ID, Constants.CANIVORE_BUS);

    TalonFXConfiguration intakeConfig =
        new TalonFXConfiguration()
            .withCurrentLimits(
                new CurrentLimitsConfigs()
                    .withSupplyCurrentLimit(40)
                    .withSupplyCurrentLimitEnable(true)
                    .withStatorCurrentLimit(100)
                    .withStatorCurrentLimitEnable(true))
            .withMotorOutput(new MotorOutputConfigs().withNeutralMode(NeutralModeValue.Coast))
            .withTorqueCurrent(
                new TorqueCurrentConfigs()
                    .withPeakForwardTorqueCurrent(80)
                    .withPeakReverseTorqueCurrent(-80))
            .withSlot1(
                new Slot1Configs()
                    .withKP(0.5)
                    .withKI(2.0)
                    .withKD(0.0)
                    .withKV(12.0 / RPM.of(6000).in(RotationsPerSecond)));

    shooterMotorLeft.getConfigurator().apply(intakeConfig);
    shooterMotorMiddle.getConfigurator().apply(intakeConfig);
    shooterMotorRight.getConfigurator().apply(intakeConfig);
  }

  @Override
  public void shooterSetVoltage(double setVoltage) {
    shooterMotorLeft.setVoltage(setVoltage);
    shooterMotorMiddle.setVoltage(setVoltage);
    shooterMotorRight.setVoltage(setVoltage);
  }
}
