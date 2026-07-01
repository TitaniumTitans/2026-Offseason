package frc.robot.subsystems.shooter;

import com.ctre.phoenix6.CANBus;
import com.ctre.phoenix6.hardware.TalonFX;
import frc.robot.Constants;

public class ShooterIOTalonFX implements ShooterIO{

  
  private final TalonFX shooterMotorLeft;
  private final TalonFX shooterMotorMiddle;
  private final TalonFX shooterMotorRight;

  ShooterIOTalonFX() {

    TalonFX shooterMotorLeft = new TalonFX(ShooterConstants.SHOOTER_LEFT_ID, Constants.CANIVORE_BUS);
    TalonFX shooterMotorMiddle = new TalonFX(ShooterConstants.SHOOTER_MIDDLE_ID, Constants.CANIVORE_BUS);
    TalonFX shooterMotorRight = new TalonFX(ShooterConstants.SHOOTER_RIGHT_ID, Constants.CANIVORE_BUS);

  }

  @Override
  void shooterSetVoltage(double setVoltage) {
    shooterMotorLeft.setVoltage(setVoltage);
    shooterMotorMiddle.setVoltage(setVoltage);
    shooterMotorRight.setVoltage(setVoltage);
  }

}
