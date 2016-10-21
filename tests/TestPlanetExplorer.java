import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void test_executeCommand() {
		PlanetExplorer explorer = new PlanetExplorer(3,3,"");
		String posObst = explorer.executeCommand("ffrf");
		assertEquals("(1,2)", posObst);
	}
	
}
