import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PuntoTest {
	
	private Punto p1, p2;

	@Before
	public void setUp() throws Exception {
		this.p1 = new Punto(2, 4);
		this.p2 = new Punto(4, 6);
	}

	@After
	public void tearDown() throws Exception {
		p1 = null;
		p2 = null;
	}

	@Test
	public void testCalcularPendiente() {
		int res = p1.calcularPendiente(p2);
		assertEquals(1, res, 0.0);
	}

	@Test
	public void testMoverPunto() {
		p1.moverPunto(5);
		assertEquals(7, p1.getX(), 0.0);
		assertEquals(9, p1.getY(), 0.0);
	}

	@Test
	public void testPuntoCentral() {
		Punto puntoCentral = p1.puntoCentral(p2);
		
		assertEquals(puntoCentral.getX(), p1.getX(), 0.0);
		assertEquals(puntoCentral.getY(), p2.getY(), 0.0);
	}

}
