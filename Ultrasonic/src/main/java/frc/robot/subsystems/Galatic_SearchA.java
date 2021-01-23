// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Ultrasonic;

public class Galatic_SearchA extends SubsystemBase {
  /** Creates a new Galatic_Search. */
  Ultrasonic ultrasonic = new Ultrasonic(1, 2);


  public Galatic_SearchA() {
    String Path;
    ultrasonic.setAutomaticMode(true);
    if(ultrasonic.getRangeInches() <= 100 && ultrasonic.getRangeInches() >= 80){
      Path = "A";

    }
    else if (ultrasonic.getRangeInches() <= 190 && ultrasonic.getRangeInches() >= 170){
      Path = "B";
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
