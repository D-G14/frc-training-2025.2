// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsytems;

import com.ctre.phoenix6.signals.NeutralModeValue;

//import com.ctre.phoenix6.configs.TalonFXConfiguration;

//import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.DriveConstants;
/*import frc.robot.subsytems.Subystems.WPI_TalonSRX;
import frc.robot.subsytems.Subystems.WPI_VictorSPX;*/
import frc.robot.subsytems.Subystems.TalonSRX;
import frc.robot.subsytems.Subystems.VictorSPX;


public class Drive extends SubsystemBase {
  /** Creates a new Drive. */
  //Created duplicate to add left and right
private final TalonSRX m_rightLeader = new TalonSRX(DriveConstants.kTalonRight);
private final TalonSRX m_leftLeader = new TalonSRX(DriveConstants.kTalonLeft);
private final VictorSPX m_leftFollower = new VictorSPX(DriveConstants.kVictorRight);
private final VictorSPX m_rightFollower = new VictorSPX(DriveConstants.kVictorLeft);
/*private final WPI_TalonSRX m_leftLeader = new WPI_TalonSRX(1);
private final WPI_TalonSRX m_leftFollower = new WPI_TalonSRX(2);
private final WPI_VictorSPX m_rightLeader = new WPI_VictorSPX(3);
private final WPI_VictorSPX m_rightFollower= new WPI_VictorSPX(4);
private final WPI_VictorSPX leftMotor = new WPI_VictorSPX(1);
private final WPI_VictorSPX rightMotor = new WPI_VictorSPX(2);
private final WPI_TalonSRX m_motorSRX = new WPI_TalonSRX(1);
private final WPI_VictorSPX m_motorSPX = new WPI_VictorSPX(2);*/

  public Drive() {
    m_leftFollower.follow(m_leftLeader);
    m_rightFollower.follow(m_rightLeader);
    m_rightLeader.setInverted(true);
    m_rightFollower.setInverted(true);
    /*m_rightLeader.setInverted(true);
    m_rightFollower.setInverted(true);*/
    m_leftLeader.setNeutralMode(NeutralModeValue.Brake);
    //Is there a need to set brakes for Follower?
    m_leftFollower.setNeutralMode(NeutralModeValue.Brake);
  }
  


    public void periodic() {
     
      
      VictorSPX.set(ControlMode.PercentOutput,0);
      TalonSRX.set(ControlMode.PercentOutput,0);
  
      double leftOutput = m_leftLeader.getMotorOutputPercent();
      double rightOutput = m_rightLeader.getMotorOutputPercent();
    SmartDashboard.putNumber("Left Motor Output",leftOutput);
    SmartDashboard.putNumber("Right Motor Output",rightOutput);
     
    // This method will be called once per scheduler run
  }
  public void setSpeed(double speed){
    m_leftLeader.set(speed);
    m_rightLeader.set(speed);
    m_leftFollower.set(speed);
    m_rightFollower.set(speed);
  }


    //This won't run because nothing actually in it; Add variables and stuff inside of it. 
    public Object driveArcade(double d, double e) {
     
      throw new UnsupportedOperationException("Unimplemented method 'driveArcade'");
    }
  
}
