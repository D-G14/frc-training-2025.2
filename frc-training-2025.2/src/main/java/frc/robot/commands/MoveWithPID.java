// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.util.sendable.SendableBuilder;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.constants.DriveTrainConstants;
import frc.robot.subsystems.DriveTrain;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class MoveWithPID extends Command {
  private final PIDController m_pid = new PIDController(DriveTrainConstants.kP, DriveTrainConstants.kI, DriveTrainConstants.kD);
  private MoveWithPIDSendable m_sendable = new MoveWithPIDSendable();
  private  double m_deadband;
  private double m_currentTicks;
  private double m_targetTicks;
  private DriveTrain m_drive;
  private double m_initialTicks;
  double m_output = m_pid.calculate(m_currentTicks, m_targetTicks);
  /** Creates a new MoveWithPID. */
  public MoveWithPID(DriveTrain drive, double targetTicks) {
    m_drive = drive;
    m_targetTicks = targetTicks;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_drive);
    m_pid.setTolerance(m_deadband);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //Do I need this --v
    //SmartDashboard.putData("MoveWithPID",m_sendable);
    m_initialTicks = m_drive.getLeftEncoderTicks();
    m_pid.reset();
    m_pid.setSetpoint(m_initialTicks + m_targetTicks);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
   m_currentTicks = m_drive.getLeftEncoderTicks();
  m_output = m_pid.calculate(m_currentTicks, m_targetTicks);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drive.setLeftSpeed(0);
    m_drive.setRightSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_pid.atSetpoint();
  }
  public MoveWithPIDSendable getSendable(){
        return m_sendable;
      }
    
    private class MoveWithPIDSendable implements Sendable {
      @Override
  public void initSendable(SendableBuilder builder) {
    builder.setSmartDashboardType("MoveWithPIDSendable");
    builder.addDoubleProperty("Output",()-> m_output, null);
    builder.addDoubleProperty("Target Ticks",() -> m_targetTicks, (double targetTicks) ->  m_targetTicks = targetTicks);
    //Could I use m_currentTicks instead of getLeftEncoderTicks? --v
    builder.addDoubleProperty("Current Ticks",() -> m_currentTicks,null);
    builder.addDoubleProperty("Starting Ticks",() -> m_initialTicks,null);
  }
}
}
