package frc.robot.subsystems.shooter;

import org.littletonrobotics.junction.AutoLog;

public interface ShooterIO {
  @AutoLog
  class ShooterIOInput {
    public double shooterRPMLeft = 0;
    public double shooterRPMMiddle = 0;
    public double shooterRPMRight = 0;
    public double shooterVoltageLeft = 0;
    public double shooterVoltageMiddle = 0;
    public double shooterVoltageRight = 0;
    public double shooterCurrentLeft = 0;
    public double shooterCurrentMiddle = 0;
    public double shooterCurrentRight = 0;
  }

  default void updateInput(ShooterIOInputAutoLogged inputs) {}

  default void shooterSetRPM(double setRPM) {}

  default void shooterSetVoltage(double setVoltage) {}

  default void shooterSetPercentage(double setPercentage) {}
}
