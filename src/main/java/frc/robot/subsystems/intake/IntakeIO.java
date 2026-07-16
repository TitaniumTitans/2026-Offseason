package frc.robot.subsystems.intake;

import org.littletonrobotics.junction.AutoLog;

public interface IntakeIO {
  @AutoLog
  class IntakeIOInput {
    public double intakePivotAngle = 0;
    public double intakeFeederRPM = 0;
    public double intakePivotVoltage = 0;
    public double intakeFeederVoltage = 0;
    public double intakePivotCurrent = 0;
    public double intakeFeederCurrent = 0;
  }

  default void updateInput(IntakeIOInputAutoLogged inputs) {}

  default void intakeSetRPM(double setRPM) {}

  default void intakeSetFeederVoltage(double setFeederVoltage) {}

  default void intakeSetPivotVoltage(double setPivotVoltage) {}
}
