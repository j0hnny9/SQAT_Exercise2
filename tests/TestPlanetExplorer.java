import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {
	
	@Test
	public void test_executeCommand_Without_obstacles__ffrf__position_1_2() {
		PlanetExplorer explorer = new PlanetExplorer(3,3,"");
		String posObst = explorer.executeCommand("ffrf");
		assertEquals("(1,2)", posObst);
	}
	
}
