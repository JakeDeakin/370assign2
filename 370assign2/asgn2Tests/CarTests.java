/**
 * 
 * This file is part of the CarParkSimulator Project, written as 
 * part of the assessment for INB370, semester 1, 2014. 
 *
 * CarParkSimulator
 * asgn2Tests 
 * 22/04/2014
 * 
 */
package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import asgn2Exceptions.VehicleException;
import asgn2Vehicles.Car;

/**
 * @author hogan
 *
 */
public class CarTests {
	private Car CarTests;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	
	/**
	 * Test method for {@link asgn2Vehicles.Car#toString()}.
	 */
	@Test
	public void testToString() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Vehicles.Car#Car(java.lang.String, int, boolean)}.
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test(expected = VehicleException.class)
	public void testCarTimeNeg() throws VehicleException {
		CarTests = new Car("TEST", -1, true);
	}
	
	/**
	 * Test method for {@link asgn2Vehicles.Car#Car(java.lang.String, int, boolean)}.
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test(expected = VehicleException.class)
	public void testCarTimeZero() throws VehicleException {
		CarTests = new Car("TEST", 0, true);
	}
	
	/**
	 * Test method for {@link asgn2Vehicles.Car#Car(java.lang.String, int, boolean)}.
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testCarTimePosSmall() throws VehicleException {
		CarTests = new Car("TEST", 1, true);
	}
	
	/**
	 * Test method for {@link asgn2Vehicles.Car#Car(java.lang.String, int, boolean)}.
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testCarTimePosLarge() throws VehicleException {
		CarTests = new Car("TEST", 100, true);
	}

	/**
	 * Test method for {@link asgn2Vehicles.Car#isSmall()}.
	 *  @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testIsSmallTrue() throws VehicleException{
		CarTests = new Car("Test", 1, true);
		assertTrue(CarTests.isSmall());
	}
	
	/**
	 * Test method for {@link asgn2Vehicles.Car#isSmall()}.
	 *  @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testIsSmallFalse() throws VehicleException{
		CarTests = new Car("Test", 1, false);
		assertFalse(CarTests.isSmall());
	}

}
