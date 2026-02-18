// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.constants.DriveTrainConstants;
import frc.robot.subsystems.DriveTrain;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class MoveForDistance extends Command {
  private double m_speed;
  private double m_distanceInFeet;
  //private double m_wheelRot;
  private double m_initialTicks;
  private double m_targetTicks;
  private double m_error;
  private DriveTrain m_drive;
  private MoveForDistanceSendable m_Sendable = new MoveForDistanceSendable();
      /** Creates a new MoveForDistance. */
      public MoveForDistance(DriveTrain drive, double speed) {
        speed = m_speed;
        drive = m_drive;
        //Old one --v is there a need for wheel Rot
        //m_targetTicks = m_distanceInFeet*m_wheelRot/(Math.PI*DriveTrainConstants.kWheelDiameter)*DriveTrainConstants.kTicksPerRotation;
        //Is this correct --v
        m_targetTicks = (m_distanceInFeet/(Math.PI*DriveTrainConstants.kWheelDiameter))*DriveTrainConstants.kTicksPerRotation;
       
    
    
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
        m_drive.setLeftSpeed(m_speed);
        m_drive.setRightSpeed(m_speed);
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
        
        return m_error <= 0;
      }
       public MoveForDistanceSendable getSendable(){
        return m_Sendable;
      }
    
    private class MoveForDistanceSendable implements Sendable {
   
    
    
  
      @Override
  public void initSendable(SendableBuilder builder) {
    builder.setSmartDashboardType("MoveForDistanceSendable");
    //null is when we don't want it to be able to be changed on smart dashboard.
    builder.addDoubleProperty("Speed",()-> m_speed, null);
    builder.addDoubleProperty("Initial Ticks",() -> m_initialTicks,null);
    builder.addDoubleProperty("Target Ticks",() -> m_targetTicks,(double kTargetTicks) -> m_targetTicks = kTargetTicks);
    builder.addDoubleProperty("Current Ticks",() -> m_drive.getLeftEncoderTicks(), null);
    builder.addDoubleProperty("error",() -> m_error,  null);
   
  }
}
}
