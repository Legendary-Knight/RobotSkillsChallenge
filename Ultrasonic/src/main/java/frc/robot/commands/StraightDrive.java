// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;

public class StraightDrive extends CommandBase {

  double targetDistance;

  /** Creates a new DriveForward. */
  public StraightDrive(double distance) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.returnDrive().getInstance());
    targetDistance = distance;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.returnDrive().resetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double Left = .5;
    double Right = .5;
    if (targetDistance < 0) {
      RobotContainer.returnDrive().tankDrive(-Left, -Right);
    } else if (targetDistance > 0) {
      RobotContainer.returnDrive().tankDrive(Left, Right);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.returnDrive().tankDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    double Left = .5;
    double Right = .5;
    if (Math.abs(targetDistance - RobotContainer.returnDrive().getEncoderDistance()) <= 2) {
      return true;
    }
    //if (RobotContainer.returnDrive().getAngle() > 0)
    Left =  .5 - ((.25*(RobotContainer.returnDrive().getAngle()))/360);
    Right =  .5 + ((.25*(RobotContainer.returnDrive().getAngle()))/360);
    //else if (RobotContainer.returnDrive().getAngle() <0)
    //Left =  .5 + ((.25*(RobotContainer.returnDrive().getAngle()))/360);
   // return false;
  }
}