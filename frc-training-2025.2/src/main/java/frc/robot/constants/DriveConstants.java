// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.constants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveConstants extends SubsystemBase {
  public static int kTalonRight = 0;
  public static int kTalonLeft = 0;
  public static int kVictorRight = 0;
public static int kVictorLeft = 0;
public static double kspeed = 0;
// public static double turnSpeed = 0;
// public static double leftSpeed = 1;
// public static double rightSpeed = -1;


  /** Creates a new DriveConstants. */
  public DriveConstants() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
