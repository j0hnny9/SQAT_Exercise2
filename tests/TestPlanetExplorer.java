import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {
	
	@Test
	public void test_executeCommand_Without_obstacles__ffrf__position_1_2() {
		PlanetExplorer explorer = new PlanetExplorer(3,3,"");
		String posObst = explorer.executeCommand("ffrf");
		assertEquals("(1,2,E)", posObst);
	}
	
	@Test
	public void test_executeCommand_Without_obstacles__frff__position_1_2() {
		PlanetExplorer explorer = new PlanetExplorer(3,3,"");
		String posObst = explorer.executeCommand("frff");
		assertEquals("(2,1,E)", posObst);
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
	
}
