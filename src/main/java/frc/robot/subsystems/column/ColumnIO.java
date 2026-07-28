package frc.robot.subsystems.column;

import org.littletonrobotics.junction.AutoLog;

public interface ColumnIO {
  @AutoLog
  class ColumnIOInput {
    public double columnRPM = 0;
    public double columnVoltage = 0;
    public double columnCurrent = 0;
    public double feederRPM = 0;
    public double feederVoltage = 0;
    public double feederCurrent = 0;
  }

  default void updateInput(ColumnIOInputAutoLogged inputs) {}

  default void columnSetColumnRPM(double setColumnRPM) {}

  default void columnSetFeederRPM(double setColumnRPM) {}

  default void columnSetColumnVoltage(double setColumnVoltage) {}

  default void columnSetFeederVoltage(double setFeederVoltage) {}
}
