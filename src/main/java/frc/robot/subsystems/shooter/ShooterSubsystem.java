package frc.robot.subsystems.shooter;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.littletonrobotics.junction.Logger;

public class ShooterSubsystem extends SubsystemBase {

  private final ShooterIO IO;
  private final ShooterIOInputAutoLogged inputs = new ShooterIOInputAutoLogged();

  public ShooterSubsystem(ShooterIO io) {

    IO = io;
  }

  @Override
  public void periodic() {
    IO.updateInput(inputs);
    Logger.processInputs("shooter", inputs);
  }

  public Command setShooterVoltage(double voltage) {
    return runEnd(() -> IO.shooterSetVoltage(voltage), () -> IO.shooterSetVoltage(0.0));
  }
}
