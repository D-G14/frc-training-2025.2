// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.MotorConstants;

public class Motor extends SubsystemBase {
  /** Creates a new Motor. */
  private SparkMax m_motor = new SparkMax(MotorConstants.kMotorID, MotorType.kBrushless);
  private SparkMaxConfig m_config = new SparkMaxConfig();


  public Motor() {
    m_config.idleMode(IdleMode.kBrake);
    m_motor.configure(m_config,ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

    
  }
  //set the motor speed
  /*public double speed;
  public void setSpeed(double Speed){
    speed = Speed;
    public void set(double speed);
    }*/
  public void setSpeed(double speed){}
  //get the motor speed
   public double getSpeed(){
    return m_motor.get();
   }
   
  /*public void getSpeed() {
  }*/
  
      @Override
      public void periodic() {
        // This method will be called once per scheduler run
        SmartDashboard.putNumber("Motor Speed",getSpeed());
      }
    }
