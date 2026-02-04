// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.


package frc.robot.subsystems;

import com.ctre.phoenix6.signals.NeutralModeValue;
//Import for the joystick --v (down arrow)
//import edu.wpi.first.wpilibj.Joystick;

//import com.ctre.phoenix6.configs.TalonFXConfiguration;

//import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.DriveConstants;



public class Drive extends SubsystemBase {
  /** Creates a new Drive. */
  //Created duplicate to add left and right
private final TalonSRX m_rightPrimary = new TalonSRX(DriveConstants.kTalonRightID);
private final TalonSRX m_leftPrimary = new TalonSRX(DriveConstants.kTalonLeftID);
private final VictorSPX m_leftSecondary = new VictorSPX(DriveConstants.kVictorLeftID);
private final VictorSPX m_rightSecondary = new VictorSPX(DriveConstants.kVictorRightID);
/*private final WPI_TalonSRX m_leftLeader = new WPI_TalonSRX(1);
private final WPI_TalonSRX m_leftFollower = new WPI_TalonSRX(2);
private final WPI_VictorSPX m_rightLeader = new WPI_VictorSPX(3);
private final WPI_VictorSPX m_rightFollower= new WPI_VictorSPX(4);
private final WPI_VictorSPX leftMotor = new WPI_VictorSPX(1);
private final WPI_VictorSPX rightMotor = new WPI_VictorSPX(2);
private final WPI_TalonSRX m_motorSRX = new WPI_TalonSRX(1);
private final WPI_VictorSPX m_motorSPX = new WPI_VictorSPX(2);*/

  public Drive() {
    m_leftSecondary.follow(m_leftPrimary);
    m_rightSecondary.follow(m_rightPrimary);
    m_rightPrimary.setInverted(true);
    m_rightSecondary.setInverted(true);
    /*m_rightLeader.setInverted(true);
    m_rightFollower.setInverted(true);*/
    m_leftPrimary.setNeutralMode(NeutralModeValue.Brake);
    //Is there a need to set brakes for Follower?
    m_leftSecondary.setNeutralMode(NeutralModeValue.Brake);
    m_rightPrimary.setNeutralMode(NeutralModeValue.Brake);
    m_rightSecondary.setNeutralMode(NeutralModeValue.Brake);
    
   
  }
  public void setleftSpeed(double speed){
    m_leftPrimary.set(speed);
    //We don't need to put the follower code, right?
    //m_leftFollower.set(speed);
  }
  public void setrightSpeed(double speed){
    m_rightPrimary.set(speed);
    //We don't need to put the follower code, right?
    //m_rightFollower.set(speed);
  }

    public void periodic() {
     
      //Is this how to get percent output? -->
      /*VictorSPX.set(ControlMode.PercentOutput,0);
      TalonSRX.set(ControlMode.PercentOutput,0);*/
      //Or is this how to get percent output? -->
     
     
    // This method will be called once per scheduler run
  }
    public double getLeftOutput(){
      return m_leftPrimary.getMotorOutputPercent();
    }
    public double getRightOutput(){
      return m_rightPrimary.getMotorOutputPercent();
    }
    /*double leftOutput = m_leftPrimary.getMotorOutputPercent();
    double rightOutput = m_rightPrimary.getMotorOutputPercent();
    SmartDashboard.putNumber("Left Motor Output",leftOutput);
    SmartDashboard.putNumber("Right Motor Output",rightOutput);*/
    public double getLeftEncoderTicks() {
     return m_leftPrimary.getSelectedSensorPosition();
    }
    public double getRightEncoderTicks(){
          return m_rightPrimary.getSelectedSensorPosition();
      
    }
    public void swerveDrive(double d, double e) {
      throw new UnsupportedOperationException("Unimplemented method 'Drive'");
    }

  /*public void setTurn(double turnSpeed){
    m_leftLeader.set(turnSpeed);
    m_rightLeader.set(turnSpeed);
    m_leftFollower.set(turnSpeed);
    m_rightFollower.set(turnSpeed);
  }*/


    
    /*public void arcadeDrive(double speed, double turnSpeed) {
     double leftSpeed = speed + turnSpeed;
     double rightSpeed = speed - turnSpeed;
     m_leftLeader.set(leftSpeed);
     m_rightLeader.set(rightSpeed);
      
    }*/
  
}
