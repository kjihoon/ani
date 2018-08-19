package animation;

interface Variable {
	
	// windows Size
	static int WINDOWS_X = 1450, WINDOWS_Y = 1000;
	
	
	// image name
	String ACT_WALKING = "action_walking_", BG = "background", IMG_EXTENSION = ".png";
	String ACT_STOP = "action_stop_";
	
	
	// animation variable
	int ANI_SPEED = 100, BG_INDEX = 2, CHAR_WALK_INDEX = 4, CHAR_STOP_INDEX = 1;
	int BG_DEC = -20, BG_X_SIZE = 4290;
	
	
	// phase
	int PHASE_WALK = 1;
	int PHASE_STOP = 2;
}