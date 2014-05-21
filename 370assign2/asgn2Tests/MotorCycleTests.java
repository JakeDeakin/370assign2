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
import asgn2Vehicles.MotorCycle;
import asgn2Vehicles.Vehicle;

/**
 * @author hogan
 *
 */
public class MotorCycleTests {
	private MotorCycle MotorCycleTests;
	//private Vehicle VehicleTests;
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

	/* --------------------------------------------------------------------------------------------*/
	/* Start of tests for MotorCycle() constructor */
	
	/**
	 * Test method for {@link asgn2Vehicles.MotorCycle#MotorCycle(java.lang.String, int)}.
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test(expected = VehicleException.class)
	public void testMotorCycleTimeNeg() throws VehicleException {
		MotorCycleTests = new MotorCycle("TEST", -1);
	}
	
	/**
	 * Test method for {@link asgn2Vehicles.MotorCycle#MotorCycle(java.lang.String, int)}.
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test(expected = VehicleException.class)
	public void testMotorCycleTimeZero() throws VehicleException {
		MotorCycleTests = new MotorCycle("TEST", 0);
	}
	
	/**
	 * Test method for {@link asgn2Vehicles.MotorCycle#MotorCycle(java.lang.String, int)}.
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testMotorCycleTimePosSmall() throws VehicleException {
		MotorCycleTests = new MotorCycle("TEST", 1);
	}
	
	/**
	 * Test method for {@link asgn2Vehicles.MotorCycle#MotorCycle(java.lang.String, int)}.
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testMotorCycleTimePosLarge() throws VehicleException {
		MotorCycleTests = new MotorCycle("TEST", 100);
	}
	
	/* End of tests for MotorCycleTests() constructor */
	/* --------------------------------------------------------------------------------------------*/

	
	
	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#Vehicle(java.lang.String, int)}.
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test(expected = VehicleException.class)
	public void testVehicle() throws VehicleException{
		
		MotorCycleTests = new MotorCycle("TEST", -1); // WORK IT OUT LATER DON"T FORGET ABOUT IT!!!!!!!!!!!!!!!!!!!!!!!!! //TODO
	}

	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#getVehID()}.
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testGetVehID() throws VehicleException {
		MotorCycleTests = new MotorCycle("TEST", 1);
		assertEquals("TEST", MotorCycleTests.getVehID());
	}

	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#getArrivalTime()}.
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testGetArrivalTime() throws VehicleException {
		MotorCycleTests = new MotorCycle("TEST", 1);
		assertEquals(1, MotorCycleTests.getArrivalTime());
	}

	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#enterQueuedState()}.
	 *  @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testEnterQueuedState() throws VehicleException {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#exitQueuedState(int)}.
	 */
	@Test
	public void testExitQueuedState() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#enterParkedState(int, int)}.
	 */
	@Test
	public void testEnterParkedState() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#exitParkedState(int)}.
	 */
	@Test
	public void testExitParkedStateInt() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#exitParkedState()}.
	 */
	@Test
	public void testExitParkedState() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#isParked()}.
	 */
	@Test
	public void testIsParked() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#isQueued()}.
	 */
	@Test
	public void testIsQueued() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#getParkingTime()}.
	 */
	@Test
	public void testGetParkingTime() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#getDepartureTime()}.
	 */
	@Test
	public void testGetDepartureTime() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#wasQueued()}.
	 */
	@Test
	public void testWasQueued() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#wasParked()}.
	 */
	@Test
	public void testWasParked() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#isSatisfied()}.
	 */
	@Test
	public void testIsSatisfied() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#toString()}.
	 */
	@Test
	public void testToString() {
		fail("Not yet implemented"); // TODO
	}

}
