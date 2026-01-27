// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.ArcadeMotor;
//import edu.wpi.first.wpilibj2.command.RunCommand;
//import frc.robot.constants.IOConstants;
import frc.robot.constants.IOConstants;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Motor;

public class RobotContainer {
  private final Drive m_drive = new Drive();
  private final Joystick m_joystick = new Joystick(IOConstants.kJoystickID);
  private final ArcadeDrive m_arcadeDrive = new ArcadeDrive(m_drive, m_joystick);
  private Motor m_motor;
  private ArcadeMotor m_arcadeMotor = new ArcadeMotor(m_motor,m_joystick);
  //private final Drive m_drivetrain = new Drive();
  //private Joystick m_joystick = new Joystick(IOConstants.kJoystickID);
  public RobotContainer() {
    m_drive.setDefaultCommand(m_arcadeDrive);
    m_motor.setDefaultCommand(m_arcadeMotor);
    configureBindings();
    //This is just me trying something --v (down arrow)
    /*m_drivetrain.setDefaultCommand(
      new RunCommand(()-> m_drivetrain.driveArcade(
        -m_drivercontroller.getY(),
        -m_drivercontroller.getX()),
        m_drivetrain));
      ;*/
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
