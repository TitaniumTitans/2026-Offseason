package frc.robot.subsystems.column;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.littletonrobotics.junction.Logger;

public class ColumnSubsystem extends SubsystemBase {
  private final ColumnIO IO;
  private final ColumnIOInputAutoLogged inputs = new ColumnIOInputAutoLogged();

  public ColumnSubsystem(ColumnIO io) {

    IO = io;
  }

  @Override
  public void periodic() {
    IO.updateInput(inputs);
    Logger.processInputs("column", inputs);
  }

  public Command setColumnColumnVoltage(double columnVoltage) {
    return runEnd(
        () -> IO.columnSetColumnVoltage(columnVoltage), () -> IO.columnSetColumnVoltage(0.0));
  }

  public Command setColumnFeederVoltage(double feederVoltage) {
    return runEnd(
        () -> IO.columnSetFeederVoltage(feederVoltage), () -> IO.columnSetFeederVoltage(0.0));
  }
}
