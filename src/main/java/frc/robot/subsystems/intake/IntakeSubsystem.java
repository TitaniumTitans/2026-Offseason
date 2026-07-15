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

  public Command setIntakeVoltage(double voltage) {
    return runEnd(() -> IO.intakeSetVoltage(voltage), () -> IO.intakeSetVoltage(0.0));
  }

  public Command setIntakePercentage(double voltage) {
    return runEnd(() -> IO.intakeSetPercentage(voltage), () -> IO.intakeSetPercentage(0.0));
  }
}
