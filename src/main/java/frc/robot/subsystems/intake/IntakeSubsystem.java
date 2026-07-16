package frc.robot.subsystems.intake;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.littletonrobotics.junction.Logger;

public class IntakeSubsystem extends SubsystemBase {

  private final IntakeIO IO;
  private final IntakeIOInputAutoLogged inputs = new IntakeIOInputAutoLogged();

  public IntakeSubsystem(IntakeIO io) {

    IO = io;
  }

  @Override
  public void periodic() {
    IO.updateInput(inputs);
    Logger.processInputs("intake", inputs);
  }

  public Command setIntakeFeederVoltage(double feederVoltage) {
    return runEnd(
        () -> IO.intakeSetFeederVoltage(feederVoltage), () -> IO.intakeSetFeederVoltage(0.0));
  }

  public Command setIntakePivotVoltage(double pivotVoltage) {
    return runEnd(
        () -> IO.intakeSetPivotVoltage(pivotVoltage), () -> IO.intakeSetPivotVoltage(0.0));
  }
}
