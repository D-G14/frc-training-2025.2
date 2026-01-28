// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.constants.DriveConstants;
import frc.robot.subsystems.Drive;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class MoveForDistance extends Command {
  private double m_speed;
  private double m_distanceInFeet;
  private double m_initialTicks;
  private double m_targetTicks;
  private double m_error;
  private Drive m_drive;
  /** Creates a new MoveForDistance. */
  public MoveForDistance(Drive drive, double speed, double distanceInFeet) {
    speed = m_speed;
    distanceInFeet = m_distanceInFeet;
    drive = m_drive;
    m_targetTicks = m_distanceInFeet/(Math.PI*DriveConstants.kWheelDiameter)*DriveConstants.kTicksPerRotation;
   


    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_error = m_targetTicks;
    m_initialTicks = m_drive.getLeftEncoderTicks();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_error = m_targetTicks + m_initialTicks - m_drive.getLeftEncoderTicks();
    m_drive.setleftSpeed(m_speed);
    m_drive.setrightSpeed(m_speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drive.setleftSpeed(0);
    m_drive.setrightSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    
    return m_error <= 0;
  }
}
