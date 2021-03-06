package org.usfirst.frc.team2585.systems;

import org.impact2585.lib2585.Drivetrain;
import org.usfirst.frc.team2585.robot.Environment;
import org.usfirst.frc.team2585.robot.RobotMap;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;

public class WheelSystem extends RobotSystem {
	SpeedController rightDrive;
	SpeedController leftDrive;
	
	Drivetrain drive;
	
	/* (non-Javadoc)
	 * @see org.usfirst.frc.team2585.systems.Initializable#init(org.usfirst.frc.team2585.Environment)
	 */
	@Override
	public void init(Environment environ) {
		super.init(environ);

		leftDrive = new Victor(RobotMap.LEFT_DRIVE_MOTOR);
		rightDrive = new Victor(RobotMap.RIGHT_DRIVE_MOTOR);
		RobotDrive botDrive = new RobotDrive(leftDrive, rightDrive);
		
		drive = new Drivetrain(botDrive);	
	}
	
	/**
	 * Pass the user inputs to the drive train to run the motors the appropriate amounts
	 */
	public void run() {
		drive.arcadeControl(input.forwardAmount(), input.rotationAmount(), false, false);
	}

	/* (non-Javadoc)
	 * @see org.impact2585.lib2585.Destroyable#destroy()
	 */
	@Override
	public void destroy() {
		drive.destroy();
	}
}
