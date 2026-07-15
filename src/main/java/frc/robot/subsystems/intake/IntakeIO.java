package frc.robot.subsystems.intake;

import org.littletonrobotics.junction.AutoLog;

public interface IntakeIO {
  @AutoLog
  class IntakeIOInput {
    public double intakePivotRPM = 0;
    public double intakeRunRPM = 0;
    public double intakePivotVoltage = 0;
    public double intakeRunVoltage = 0;
    public double intakePivotCurrent = 0;
    public double intakeRunCurrent = 0;
  }

  default void updateInput(IntakeIOInputAutoLogged inputs) {}

  default void intakeSetRPM(double setRPM) {}

  default void intakeSetVoltage(double setVoltage) {}

  default void intakeSetPercentage(double setPercentage) {}
}
