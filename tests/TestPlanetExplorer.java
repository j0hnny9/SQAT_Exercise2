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
	public void test_changeDirection_Without_obstacles_NorthDirection__Command_right__DirectionEast() {
		String changedDir = changeDirection("N","r");
		assertEquals("E", changedDir);
	}
	
	
	
}
