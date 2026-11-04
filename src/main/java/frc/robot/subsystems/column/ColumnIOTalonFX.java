package frc.robot.subsystems.column;

import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;

public class ColumnIOTalonFX implements ColumnIO {
  private final TalonFX columnMotor;
  private final TalonFX feederMotor;

  public ColumnIOTalonFX() {
    columnMotor = new TalonFX(ColumnConstants.COLUMN_ID);
    feederMotor = new TalonFX(ColumnConstants.FEEDER_ID);

    TalonFXConfiguration columnConfig =
        new TalonFXConfiguration()
            .withCurrentLimits(
                new CurrentLimitsConfigs()
                    .withStatorCurrentLimit(120)
                    .withStatorCurrentLimitEnable(true))
            .withMotorOutput(
                new MotorOutputConfigs().withInverted(InvertedValue.Clockwise_Positive));

    columnMotor
        .getConfigurator()
        .apply(
            columnConfig.withMotorOutput(
                new MotorOutputConfigs().withInverted(InvertedValue.CounterClockwise_Positive)));
    feederMotor
        .getConfigurator()
        .apply(
            columnConfig.withMotorOutput(
                new MotorOutputConfigs().withInverted(InvertedValue.Clockwise_Positive)));
  }

  @Override
  public void columnSetColumnVoltage(double setColumnVoltage) {
    columnMotor.setVoltage(setColumnVoltage);
  }

  @Override
  public void columnSetFeederVoltage(double setFeederVoltage) {
    feederMotor.setVoltage(setFeederVoltage);
  }
}
