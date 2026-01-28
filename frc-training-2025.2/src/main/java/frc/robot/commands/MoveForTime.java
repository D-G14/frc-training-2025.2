// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drive;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class MoveForTime extends Command {
  private Drive m_drive;
  private double m_speed;
  private double m_timeInSeconds;
  private Timer m_timer = new Timer();
  /** Creates a new MoveForTime. */
  public MoveForTime(Drive drive, double timeInSeconds, double speed) {
    drive = m_drive;
    timeInSeconds = m_timeInSeconds;
    speed = m_speed;
    
 
    // Use addRequirements() here to declare subsystem dependencies.
   addRequirements(m_drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_timer.start();
    m_timer.reset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drive.setleftSpeed(m_speed);
    m_drive.setrightSpeed(m_speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drive.setleftSpeed(0);
    m_drive.setrightSpeed(0);
    m_timer.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
  
    return m_timer.hasElapsed(m_timeInSeconds);
  }
}
