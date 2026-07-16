package frc.robot.subsystems.intake;

import com.ctre.phoenix6.hardware.TalonFX;
import frc.robot.Constants;

public class IntakeIOTalonFX implements IntakeIO {

  private final TalonFX intakeMotorPivot;
  private final TalonFX intakeMotorFeeder;

  public IntakeIOTalonFX() {

    intakeMotorPivot = new TalonFX(IntakeConstants.INTAKE_PIVOT_ID, Constants.CANIVORE_BUS);
    intakeMotorFeeder = new TalonFX(IntakeConstants.INTAKE_FEEDER_ID, Constants.CANIVORE_BUS);
  }

  @Override
  public void intakeSetFeederVoltage(double setFeederVoltage) {
    intakeMotorFeeder.setVoltage(setFeederVoltage);
  }

  @Override
  public void intakeSetPivotVoltage(double setPivotVoltage) {
    intakeMotorPivot.setVoltage(setPivotVoltage);
  }
}
