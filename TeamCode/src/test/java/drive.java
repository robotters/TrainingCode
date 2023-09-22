import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import github.robotters.training.simba.logic.DriveLogic;
import github.robotters.training.simba.logic.DriveLogic.RobotOrientedDriveData;

class Drive {
	@Test
	void testLogic() {
		DriveLogic driveLogic = new DriveLogic();
		RobotOrientedDriveData robotOrientedDriveData = new RobotOrientedDriveData(-2.5, 3.2, 5.3);
		assertEquals(robotOrientedDriveData, driveLogic.calcDriveInputs(2.5, 3.2, 5.3));
	}
}
