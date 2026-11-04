package frc.robot.subsystems.shooter;

import com.ctre.phoenix6.configs.*;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import frc.robot.Constants;

public class ShooterIOTalonFX implements ShooterIO {

  private final TalonFX shooterMotorLeft;
  private final TalonFX shooterMotorMiddle;
  private final TalonFX shooterMotorRight;

  public Slot0Configs Slot0 = new Slot0Configs();

  public final ShooterIOTalonFX withSlot0(Slot0Configs newSlot0) {
    this.Slot0 = newSlot0;
    return this;
  }

  Slot0Configs slot0Configs =
      new Slot0Configs().withKP(0.0).withKI(0.0).withKD(0.0).withKV(0.0).withKS(0.0);

  public ShooterIOTalonFX() {

    shooterMotorLeft = new TalonFX(ShooterConstants.SHOOTER_LEFT_ID, Constants.CANIVORE_BUS);
    shooterMotorMiddle = new TalonFX(ShooterConstants.SHOOTER_MIDDLE_ID, Constants.CANIVORE_BUS);
    shooterMotorRight = new TalonFX(ShooterConstants.SHOOTER_RIGHT_ID, Constants.CANIVORE_BUS);

    TalonFXConfiguration shooterConfig =
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
                    .withPeakReverseTorqueCurrent(-80));

    shooterMotorLeft.getConfigurator().apply(shooterConfig);
    shooterMotorMiddle.getConfigurator().apply(shooterConfig);
    shooterMotorRight
        .getConfigurator()
        .apply(
            shooterConfig.withMotorOutput(
                new MotorOutputConfigs()
                    .withNeutralMode(NeutralModeValue.Coast)
                    .withInverted(InvertedValue.Clockwise_Positive)));
  }

  @Override
  public void shooterSetVoltage(double setVoltage) {
    shooterMotorLeft.setVoltage(setVoltage);
    shooterMotorMiddle.setVoltage(setVoltage);
    shooterMotorRight.setVoltage(setVoltage);
  }

  @Override
  public void shooterSetRPM(double setRPM) {
    shooterMotorLeft.getConfigurator().apply(slot0Configs);
    shooterMotorMiddle.getConfigurator().apply(slot0Configs);
    shooterMotorRight.getConfigurator().apply(slot0Configs);
  }
}
