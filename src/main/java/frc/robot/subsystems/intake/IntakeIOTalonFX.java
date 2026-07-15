package frc.robot.subsystems.intake;

import com.ctre.phoenix6.hardware.TalonFX;
import frc.robot.Constants;

public class IntakeIOTalonFX implements IntakeIO {

  private final TalonFX intakeMotorPivot;
  private final TalonFX intakeMotorRun;

  public IntakeIOTalonFX() {

    intakeMotorPivot = new TalonFX(IntakeConstants.INTAKE_PIVOT_ID, Constants.CANIVORE_BUS);
    intakeMotorRun = new TalonFX(IntakeConstants.INTAKE_RUN_ID, Constants.CANIVORE_BUS);
  }

  @Override
  public void intakeSetVoltage(double setVoltage) {
    intakeMotorRun.setVoltage(setVoltage);
  }
}
