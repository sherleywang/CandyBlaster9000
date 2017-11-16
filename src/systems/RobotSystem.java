package systems;


import org.impact2585.lib2585.Destroyable;
import org.usfirst.frc.team2585.robot.Environment;

import input.InputMethod;

/**
 * Parent class of the systems that will run on the robot
 */
public abstract class RobotSystem implements Destroyable, Initializable {
	protected InputMethod input;
	
	/* (non-Javadoc)
	 * @see org.usfirst.frc.team2585.systems.Initializable#init(org.usfirst.frc.team2585.Environment)
	 */
	public void init(Environment environ) {
		input = environ.getInput();
	}
	
	/**
	 * @param newInput the input to set
	 */
	public synchronized void setInput(InputMethod newInput) {
		input = newInput;
	}

}
