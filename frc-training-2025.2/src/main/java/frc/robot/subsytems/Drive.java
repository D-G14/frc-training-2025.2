// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsytems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsytems.Subystems.TalonSRX;
import frc.robot.subsytems.Subystems.VictorSPX;


public class Drive extends SubsystemBase {
  /** Creates a new Drive. */
private final TalonSRX m_leftPrimary = new TalonSRX();
private final TalonSRX m_leftSecondary = new TalonSRX();
private final VictorSPX m_rightPrimary = new VictorSPX(0);
private final VictorSPX m_rightSecondary = new VictorSPX(0);
TalonSRX leftLeader = new TalonSRX(1);
TalonSRX leftFollower = new TalonSRX(2);
VictorSPX rightLeader = new VictorSPX(3);
VictorSPX rightFollower = new VictorSPX(4);


  public Drive() {}
    private final VictorSPX leftMotor = new VictorSPX(1);
    private final VictorSPX rightMotor = new VictorSPX(2);
  private final TalonSRX m_motorSRX = new TalonSRX(1);
  private final VictorSPX m_motorSPX = new VictorSPX(2);
  

    @Override
    public void periodic() {
      m_leftPrimary.setInverted(false);
      m_leftSecondary.setInverted(false);
      m_rightPrimary.setInverted(true);
      m_rightSecondary.setInverted(true);
       m_motorSRX.setNeutralMode(NeutralMode.Brake);
       m_motorSPX.setNeutralMode(NeutralMode.Brake);
      VictorSPX.set(ControlMode.PercentOutput,0);
      TalonSRX.set(ControlMode.PercentOutput,0);
  
      double leftOutput = leftMotor.get();
      double rightOutput = rightMotor.get();
    SmartDashboard.putNumber("Left Motor Output",leftOutput);
    SmartDashboard.putNumber("Right Motor Output",rightOutput);
     
    // This method will be called once per scheduler run
  }
  
}
