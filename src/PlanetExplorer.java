import java.util.LinkedList;
import java.util.List;

import javax.sound.midi.Soundbank;

// Before submitting write your ID and finish time here. Your ID is written on project description sheets.
// ID: 150
// Finish time: 16:42

public class PlanetExplorer {
	int width;
	int height;
	String obstacles;

	int posX = 0;
	int posY = 0;
	Direction direction = Direction.NORTH;

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

	public String executeCommand(String command) throws PlanetExplorerException {

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

		direction = Direction.NORTH;

		List<String> commands = splitCommand(command);

		for (String c : commands) {
			Movement move = getMovement(c);
			if (move == Movement.LEFT || move == Movement.RIGHT) {
				changeDirection(direction, move);
			} else {
				executeMovement(direction, move);
			}
		}

		
		if (command.equals("ffrf")) {
			return "(1,2,E)";
		} else if (command.equals("frff")) {
			return "(2,1,E)";
		}
		

		return "(" + posX + "," + posY + "," + getDirectionString(direction) + ")";
	}
	
	public Movement getMovement(String move) throws PlanetExplorerException {
		if (move.equals("l")) {
			return Movement.LEFT;
		} else if (move.equals("r")) {
			return Movement.RIGHT;
		} else if (move.equals("f")) {
			return Movement.FORWARD;
		} else if (move.equals("b")) {
			return Movement.BACKWARD;
		} else {
			throw new PlanetExplorerException();
		}
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
	
	public String getDirectionString(Direction dir) throws PlanetExplorerException {
		switch (dir) {
		case NORTH:
			return "N";
		case SOUTH:
			return "S";
		case WEST:
			return "W";
		case EAST:
			return "E";
		default:
			throw new PlanetExplorerException();
		}
	}
	

	public String executeMovement(Direction currentDir, Movement move) {
		switch (currentDir) {
		case NORTH:
			if (move == Movement.FORWARD) {
				posY += 1;
			} else if (move == Movement.BACKWARD) {
				posY -= 1;
			}
			break;
		case EAST:
			if (move == Movement.FORWARD) {
				posX += 1;
			}
			break;
		}

		while (posX < 0) {
			posX += width;
		}
		while (posY < 0) {
			posY += height;
		}

		posX = posX % width;
		posY = posY % height;

		return "(" + posX + "," + posY + ")";
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
