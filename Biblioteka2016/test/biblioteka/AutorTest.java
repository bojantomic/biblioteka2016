package biblioteka;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AutorTest {

	private Autor a;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		a = new Autor();
	}

	@After
	public void tearDown() throws Exception {
		a = null;
	}

	
	@Test
	public void testSetImeSveOk() {
		String ime = "Pera";
		
		a.setIme(ime);
		
		assertEquals(ime, a.getIme());
	}
	
	@Test
	public void testSetImeSveOk2() {
		String ime = "Iv";
		
		a.setIme(ime);
		
		assertEquals(ime, a.getIme());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetImeNull() {
		a.setIme(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetImePrazan() {
		a.setIme("");
	}

}
