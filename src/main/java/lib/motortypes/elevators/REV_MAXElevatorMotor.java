package lib.motortypes.elevators;

import com.revrobotics.CANSparkMax;
import lib.motormechanisms.controlrequests.CurrentRequest;
import lib.motormechanisms.controlrequests.LinearPositionRequest;
import lib.motormechanisms.controlrequests.LinearVelocityRequest;
import lib.motormechanisms.controlrequests.VoltageRequest;
import lib.motortypes.MotorControllerType;

public class REV_MAXElevatorMotor extends CANSparkMax implements ElevatorMotor {
    // TODO: Malaika: Start Here.  Don't forget to import imports.
    // TODO: create a ElevatorFeedforward object named feedforward.  private final.
    // TODO: create  a Trapezoid object named trapezoidProfile. private final.
    // TODO: create an ExponentialProfile named exponential profile.  private final.
    // TODO: create a SlewRateLimiter named slewRateLimiter. private final.
    // TODO: create a TrapezoidProfile.State named trapGoalState. private final. initialize to new Trapezoid.State();
    // TODO: repeat for a variable named expoGoalState using ExponentialProfile.State
    // TODO: create a TrapezoidPofile.State named lastTrapState.  Follows same logic as before.
    // TODO: repeate for a variable named lastExpoState.  Same logic as before.

    public REV_MAXElevatorMotor(REV_MAXElevatorMotorConfig config) {
        super(config.deviceNumber(), MotorType.kBrushless);
        // TODO: call setInverted passing in invertedValue from config
        // TODO: call setIdleMode passing in value from config.
        // TODO: call getEncoder().setAverageDepth passing in value from config.
        // TODO: call getEncoder().setMeasurementPeriod passing in value from config.
        // TODO: call getEncoder().setPositionConversionFactor passing in 2 * Math.PI / sensorToMechanismRatio.
        // sensorToMechanismRatio comes from config.
        // TODO: call getEncoder().setVelocityConversionFactor passing in 2 * Math.PI / sensorToMechanismRatio / 60.0
        // TODO: call getPIDController().setP, I, D for voltagePosition P, I, D using 0 for slotID.  These are 3 similar TODO's
        // TODO: repeat for voltageVelocity PID using 1 for slotID.  These are 3 similar TODO's
        // TODO: initialize feedforward to new ElevatorFeedforward passing in ks, kg, kv, ka from config.
        // TODO: initialize trapezoidProfile to new TrapezoidProfile(new TrapezoidProfile.Constraints().  passing in maxVelocity and maxAcceleration from config.
        // TODO: initialize exponentialProfile to a new ExponentialProfile(ExponentialProfile.Constraints.fromCharacteristics(12.0, voltageKv, voltageKa)
        // TODO: initialize slewRateLimiter to new SlewRateLimiter passing in maxAcceleration from config
    }

    @Override
    public int getCanId() {
        // TODO: return getDeviceId();
        return 0; // TODO: remove this placeholder.
    }

    @Override
    public String getCanNetworkName() {
        // TODO: return "rio";
        return null; // TODO: remove this placeholder.
    }

    @Override
    public MotorControllerType getMotorControllerType() {
        // TODO: return MotorControllerType.REV_SPARK_MAX;
        return null; // TODO: remove this placeholder.
    }

    @Override
    public double getCurrentAmps() {
        // TODO: return getOutputCurrent();
        return 0.0; // TODO: remove this placeholder.

    }

    @Override
    public double getVoltageVolts() {
        // TODO: return getAppliedOutput() * getBusVoltage();
        return 0.0; // TODO: remove this placeholder.
    }

    @Override
    public double getPositionMeters() {
        // TODO: return getEncoder().getPosition;
        return 0.0; // TODO: remove this placeholder.
    }

    @Override
    public void setLinearPosition(double positionMeters) {
        // TODO: call getEncoder().setPosition passing in positionMeters
    }

    @Override
    public double getVelocityMetersPerSecond() {
        // TODO: return getEncoder().getVelocity;
        return 0.0; // TODO: remove this placeholder.
    }

    @Override
    public void accept(VoltageRequest request) {
        // TODO: call getPIDController().setReference passing in volts from request and ControlType.kVoltage
    }

    @Override
    public void accept(CurrentRequest request) {
        // TODO: call getPIDController().setReference passing in current from request and ControlType.kCurrent
    }

    @Override
    public void acceptPositionVoltage(LinearPositionRequest request) {
        // TODO: create a double feedforwardVoltage variable and initialize to feedfoward.calculate() passing in
        // getVelocityMetersPerSecond and 0.0 and 0.020
        // TODO: call getPIDController().setReference passing in position from request, ControlType.kPosition, 0, feedforwardVoltage, ArbFFUnits.kVoltage
        // TODO: set lastTrapState.position to getPositionMeters
        // TODO: set lastTrapState.velocity similarly to position but for velocity.
        // TODO: call trackExpoFromTrap()
    }


    @Override
    public void acceptTrapPositionVoltage(LinearPositionRequest request) {
        // TODO: set trapGoalState.position to the position stored in request.
        // TODO: set trapGoalState.velocity to 0.0;
        // TODO: set lastTrapState to trapezoidProfile.calculate(0.020, lastTrapState, trapGoalState)
        // TODO: create a double called feedForwardVoltage and get from feedfoward.calculate(getVelocity from request, lastTrapState.velocity, 0.020)
        // TODO: call getPIDController().setReference passing in lastTrapState.position, Controltype.kPosition, 0, feedforwardVoltags, ArbFFUnits.kVoltage
        // TODO: call trackExpoFromTrap()
    }

    @Override
    public void acceptExpoPositionVoltage(LinearPositionRequest request) {
        // TODO: set expoGoalState.position to position from request passing in angle from request
        // TODO: set expoGoalState.velocity to 0.0;
        // TODO: set lastExpoState to exponentialProfile.calculate(0.020, lastExpoState, expoGoalState)
        // TODO: create a double called feedForwardVoltage and get from feedfoward.calculate(getVelocity, lastTrapState.velocity, 0.020)
        // TODO: call getPIDController().setReference passing in lastExpoState.position, Controltype.kPosition, 0, feedforwardVoltags, ArbFFUnits.kVoltage
        // TODO: call trackTrapFromExpo()
    }


    @Override
    public void acceptVelocityVoltage(LinearVelocityRequest request) {
        // TODO: create a double called feedforwardVoltage and get from feedforward.calculate(getVelocity, velocity from request, 0.020);
        // TODO: call getPIDController().setReference passing in velocity from request, ControlType.kVelocity, 1, feedfowardVoltage, ArbFFUnits.kVoltage
        // TODO: set lastTrapState.position to getPosition
        // TODO: repeat for lastTrapState.velocity using velocity
        // TODO: set lastExpoState.position to lastTrapState.position
        // TODO: repeat for lastExpoState's velocity
        // TODO: call slewRateLimiter's reset method passing in lastTrapState.velocity
    }

    @Override
    public void acceptTrapVelocityVoltage(LinearVelocityRequest request) {
        // TODO: set lastTrapState.velocity to slewRateLimiter.calculate(passing in velocity from request.
        // TODO: create a double called feedfowardVoltage and get from feedfoward.calculate() passing getVelocity, velocity from request, 0.020
        // TODO: call getPIDController().setReference passing in lastTrapState.velocity, ControlType.kVelocity, 1, feedfowardVoltage, ArbFFUnits.kVoltage
        // TODO: set lastTrapState.position to getPosition
        // TODO: set lastExpoState.position to lastTrapState.position
        // TODO: repeat for lastExpoState's velocity.
    }

    @Override
    public void acceptPositionCurrent(LinearPositionRequest request) {
        // TODO: call acceptTrapPositionVoltage(request);
    }

    @Override
    public void acceptTrapPositionCurrent(LinearPositionRequest request) {
        // TODO: call acceptTrapPositionVoltage(request);
    }


    @Override
    public void acceptExpoPositionCurrent(LinearPositionRequest request) {
        // TODO: call acceptExpoPositionCurrent(request);
    }

    @Override
    public void acceptVelocityCurrent(LinearVelocityRequest request) {
        // TODO: call acceptVelocityVoltage(request);
    }

    @Override
    public void acceptTrapVelocityCurrent(LinearVelocityRequest request) {
        // TODO: call acceptTrapVelocityVoltage(request);
    }

    private void trackExpoFromTrap() {
        // TODO: set lastExpoState.position to lastTrapState.position
        // TODO: repeat for lastExpoState.velocity for velocity.
        // TODO: call slewRateLimiter's reset method passing in lastTrapState.velocity.
    }

    private void trackTrapFromExpo() {
        // TODO: set lastTrapState.position to lastExpoState.position
        // TODO: repeat for lastTrapState.velocity for velocity.
        // TODO: call slewRateLimiter's reset method passing in lastExpoState.velocity.
    }
}
