package frc.robot.subsystems.intake;

import static edu.wpi.first.units.Units.*;

import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.configs.*;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.FeedbackSensorSourceValue;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Current;
import edu.wpi.first.units.measure.Voltage;
import frc.robot.Constants;

public class IntakeIOTalonFX implements IntakeIO {

  private final TalonFX intakeMotorPivot;
  private final TalonFX intakeMotorFeeder;

  public IntakeIOTalonFX() {

    intakeMotorPivot = new TalonFX(IntakeConstants.INTAKE_PIVOT_ID, Constants.CANIVORE_BUS);
    intakeMotorFeeder = new TalonFX(IntakeConstants.INTAKE_FEEDER_ID, Constants.CANIVORE_BUS);

    StatusSignal<Angle> pivotAngle;
    StatusSignal<Voltage> pivotVoltage, feederVoltage;
    StatusSignal<Current> pivotSupplyCurrent, pivotStatorCurrent, feederSupplyCurrent, feederStatorCurrent;

    double PIVOT_GEAR_RATIO = 50;
    // 6000 RPM
    AngularVelocity PIVOT_MAX_SPEED = RPM.of(5800).div(PIVOT_GEAR_RATIO);

    TalonFXConfiguration intakeConfig =
        new TalonFXConfiguration()
            .withMotorOutput(
                new MotorOutputConfigs()
                    .withInverted(InvertedValue.CounterClockwise_Positive)
                    .withNeutralMode(NeutralModeValue.Brake))
            .withMotionMagic(
                new MotionMagicConfigs()
                    .withMotionMagicCruiseVelocity(PIVOT_MAX_SPEED)
                    .withMotionMagicAcceleration(PIVOT_MAX_SPEED.per(Second)))
            .withFeedback(
                new FeedbackConfigs()
                    .withSensorToMechanismRatio(PIVOT_GEAR_RATIO)
                    .withFeedbackSensorSource(FeedbackSensorSourceValue.RotorSensor))
            .withCurrentLimits(
                new CurrentLimitsConfigs()
                    .withStatorCurrentLimit(Amps.of(120))
                    .withStatorCurrentLimitEnable(true)
                    .withSupplyCurrentLimit(70)
                    .withSupplyCurrentLimitEnable(true));

    intakeMotorPivot.getConfigurator().apply(intakeConfig);
    intakeMotorFeeder.getConfigurator().apply(intakeConfig);

    pivotAngle = intakeMotorPivot.getPosition();
    pivotVoltage = intakeMotorPivot.getMotorVoltage();
    pivotSupplyCurrent = intakeMotorPivot.getSupplyCurrent();
    pivotStatorCurrent = intakeMotorPivot.getStatorCurrent();

    feederVoltage = intakeMotorFeeder.getMotorVoltage();
    feederSupplyCurrent = intakeMotorFeeder.getSupplyCurrent();
    feederStatorCurrent = intakeMotorFeeder.getStatorCurrent();

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
