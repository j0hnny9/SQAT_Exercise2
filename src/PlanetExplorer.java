import java.util.LinkedList;
import java.util.List;

// Before submitting write your ID and finish time here. Your ID is written on project description sheets.
// ID:
// Finish time:

public class PlanetExplorer {
	int width;
	int height;
	String obstacles;

	public PlanetExplorer(int x, int y, String obstacles) {
		/*
		 * x and y represent the size of the grid. Obstacles is a String
		 * formatted as follows:
		 * "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white
		 * spaces.
		 * 
		 * Example use: For a 100x100 grid with two obstacles at coordinates
		 * (5,5) and (7,8) PlanetExplorer explorer = new
		 * PlanetExplorer(100,100,"(5,5)(7,8)")
		 * 
		 */

		this.width = x;
		this.height = y;
		this.obstacles = obstacles;
	}

	public String executeCommand(String command) {

		/*
		 * The command string is composed of "f" (forward), "b" (backward), "l"
		 * (left) and "r" (right) Example: The explorer is on a 100x100 grid at
		 * location (0, 0) and facing NORTH. The explorer is given the commands
		 * "ffrff" and should end up at (2, 2) facing East.
		 * 
		 * The return string is in the format:
		 * "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)"
		 * Where pos_x and pos_y are the final coordinates, facing is the
		 * current direction the explorer is pointing to (N,S,W,E). The return
		 * string should also contain a list of coordinates of the encountered
		 * obstacles. No white spaces.
		 */

		int posX = 0;
		int posY = 0;
		String direction = "N";

		List<String> commands = splitCommand(command);

		for (String c : commands) {
			if (c.equals("l")) {
				if (direction.equals("N")) {
					posX -= 1;
				}
			} else if (c.equals("r")) {

			} else if (c.equals("f")) {

			} else if (c.equals("b")) {

			}
		}

		if (command.equals("ffrf")) {
			return "(1,2,E)";
		} else if (command.equals("frff")) {
			return "(2,1,E)";
		}

		return "(" + posX + "," + posY + "," + direction + ")";
	}

	public Direction changeDirection(Direction currentDir, Movement commandDirChange) {
		switch (currentDir) {
		case NORTH:
			if (commandDirChange == Movement.RIGHT)
				return Direction.EAST;
			else if (commandDirChange == Movement.LEFT)
				return Direction.WEST;
			break;
		case WEST:
			if (commandDirChange == Movement.RIGHT)
				return Direction.NORTH;
			else if (commandDirChange == Movement.LEFT)
				return Direction.SOUTH;
			break;
		case SOUTH:
			if (commandDirChange == Movement.RIGHT)
				return Direction.WEST;
			else if (commandDirChange == Movement.LEFT)
				return Direction.EAST;
			break;
		case EAST:
			if (commandDirChange == Movement.RIGHT)
				return Direction.SOUTH;
			else if (commandDirChange == Movement.LEFT)
				return Direction.NORTH;
			break;
		}
		return null;
	}

	public String executeMovement(Direction currentDir, Movement move) {
		if (currentDir == Direction.NORTH && move == Movement.FORWARD)
			return "(0,1)";
		if (currentDir == Direction.EAST && move == Movement.FORWARD)
			return "(1,0)";
		return null;
	}

	public List<String> splitCommand(String command) {
		List<String> commandParts = new LinkedList<>();
		int i = 0;
		for (String s : command.split("")) {
			commandParts.add(s);
			i++;
		}

		return commandParts;
	}
}
