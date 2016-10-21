import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class TestPlanetExplorer {
	
	@Test
	public void test_executeCommand_Without_obstacles__ffrf__position_1_2() {
		PlanetExplorer explorer = new PlanetExplorer(3,3,"");
		String posAndObst = explorer.executeCommand("ffrf");
		assertEquals("(1,2,E)", posAndObst);
	}
	
	@Test
	public void test_executeCommand_Without_obstacles__frff__position_1_2() {
		PlanetExplorer explorer = new PlanetExplorer(3,3,"");
		String posAndObst = explorer.executeCommand("frff");
		assertEquals("(2,1,E)", posAndObst);
	}
	
	@Test
	public void test_splitCommand_Without_obstacles__frff__commands() {
		PlanetExplorer explorer = new PlanetExplorer(3,3,"");
		List<String> commands = explorer.splitCommand("frff");
		String command = "";
		for (String s : commands) {
			command += s;
		}
		assertEquals("frff", command);
	}
	
	@Test
	public void test_changeDirection_NorthDirection__Command_right__DirectionEast() {
		PlanetExplorer explorer = new PlanetExplorer(0,0,"");
		Direction changedDir = explorer.changeDirection(Direction.NORTH, Movement.RIGHT);
		assertEquals(Direction.EAST, changedDir);
	}
	
	@Test
	public void test_changeDirection_NorthDirection__Command_left__DirectionEast() {
		PlanetExplorer explorer = new PlanetExplorer(0,0,"");
		Direction changedDir = explorer.changeDirection(Direction.NORTH, Movement.LEFT);
		assertEquals(Direction.WEST, changedDir);
	}
	
	@Test
	public void test_changeDirection_WestDirection__Command_left__DirectionSouth() {
		PlanetExplorer explorer = new PlanetExplorer(0,0,"");
		Direction changedDir = explorer.changeDirection(Direction.WEST, Movement.LEFT);
		assertEquals(Direction.SOUTH, changedDir);
	}
	
	@Test
	public void test_changeDirection_SouthDirection__Command_left__DirectionEast() {
		PlanetExplorer explorer = new PlanetExplorer(0,0,"");
		Direction changedDir = explorer.changeDirection(Direction.SOUTH, Movement.LEFT);
		assertEquals(Direction.EAST, changedDir);
	}
	
	@Test
	public void test_move1__NortDirection__Command_Forward__PositionX_0_PositionY_1() {
		PlanetExplorer explorer = new PlanetExplorer(3,3,"");
		String posAfterMove = explorer.executeMovement(Direction.NORTH, Movement.FORWARD);
		assertEquals("(0,1)", posAfterMove);
	}
	
	@Test
	public void test_move1__EastDirection__Command_Forward__PositionX_1_PositionY_0() {
		PlanetExplorer explorer = new PlanetExplorer(3,3,"");
		String posAfterMove = explorer.executeMovement(Direction.EAST, Movement.FORWARD);
		assertEquals("(1,0)", posAfterMove);
	}
	
	
}
