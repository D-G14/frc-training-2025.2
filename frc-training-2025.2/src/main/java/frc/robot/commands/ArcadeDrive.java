// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
//IOConstant import here --v
//import frc.robot.constants.IOConstants;
import frc.robot.constants.MotorConstants;
import frc.robot.subsytems.Drive;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class ArcadeDrive extends Command {
  //declaring drivetrain
  private Drive m_drive;
  //declaring joystick
  private Joystick m_joystick;
  //4 variables 
  private double m_speed;
  private double m_turn;
  private double m_left;
  private double m_right;
  /** Creates a new ArcadeDrive. */
  public ArcadeDrive(Drive m_drive, Joystick m_joystick) {
    this.m_drive = m_drive;
    this.m_joystick = m_joystick;
    addRequirements(m_drive);
    // Use addRequirements() here to declare subsystem dependencies.
  }
  

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
   //do I need this? -->
    //m_speed = m_joystick.getRawAxis(IOConstants.kMotorControlAxis) * MotorConstants.kArcadeMultiplier;
  //invert because y is negative when going forward.
  m_speed = -m_joystick.getY() * MotorConstants.kArcadeMultiplier; 
  m_turn = m_joystick.getX()  * MotorConstants.kTurnMultiplier;
  //turns left because turn is getting subtracted from speed, but turn has to be negative.
  m_left = m_speed + m_turn;
  //turns right because turn is getting subtracted from speed, and turn is positive.
  m_right = m_speed - m_turn;
  m_drive.setrightSpeed(m_right);
  m_drive.setleftSpeed(m_left);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //Doesn't this stop the motor when command stops?
    m_drive.arcadeDrive(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
