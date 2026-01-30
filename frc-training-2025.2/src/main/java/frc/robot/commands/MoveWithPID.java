// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.util.sendable.SendableBuilder;
//import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.constants.DriveConstants;
import frc.robot.subsystems.Drive;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class MoveWithPID extends Command {
  private final PIDController m_pid = new PIDController(0, 0, 0);
  private MoveWithPIDSendable m_sendable = new MoveWithPIDSendable();
  private final double m_deadband = 0.5;
  private double m_currentTicks;
  private double m_targetTicks;
  private Drive m_drive;
  private double m_initialTicks;
  private double m_error;
  double m_output = m_pid.calculate(m_currentTicks, m_targetTicks);
  /** Creates a new MoveWithPID. */
  public MoveWithPID(Drive drive, double targetTicks) {
    m_drive = drive;
    m_targetTicks = targetTicks;

   
   
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_drive);
    m_pid.setTolerance(m_deadband);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_pid.reset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double m_currentTicks = m_drive.getLeftEncoderTicks();
    double m_output = m_pid.calculate(m_currentTicks, m_targetTicks);
   m_error = m_targetTicks + m_initialTicks - m_currentTicks;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_error < m_deadband;
  }
  public MoveWithPIDSendable getSendable(){
        return m_sendable;
      }
    
    private class MoveWithPIDSendable implements Sendable {
   
    
    
  
      @Override
  public void initSendable(SendableBuilder builder) {
    builder.setSmartDashboardType("MoveWithPIDSendable");
    builder.addDoubleProperty("Output",()-> m_output, null);
    builder.addDoubleProperty("Target Ticks",() -> m_targetTicks, (double kTargetTicks) ->  m_targetTicks = kTargetTicks);
    builder.addDoubleProperty("Error",() -> m_error, null);
    
   
  }
}
}
