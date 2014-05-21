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


/**
 * @author hogan
 *
 */
public class MotorCycleTests {
	private MotorCycle MotorCycleTests;

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

	/* Start of Vehicle tests */
	
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

	/* ------------------------------------------------------------------------------------------ */
	
	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#enterQueuedState()}.
	 *  @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testEnterQueuedStateNew() throws VehicleException {
		MotorCycleTests = new MotorCycle("TEST", 1);
		MotorCycleTests.enterQueuedState();
	}
	
	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#enterQueuedState()}.
	 *  @author Jake n8509956 and Jamie n8853312
	 */
	@Test(expected = VehicleException.class)
	public void testEnterQueuedStateQueued() throws VehicleException {
		MotorCycleTests = new MotorCycle("TEST", 1);
		MotorCycleTests.enterQueuedState();
		MotorCycleTests.enterQueuedState();
	}
	
	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#enterQueuedState()}.
	 *  @author Jake n8509956 and Jamie n8853312
	 */
	@Test(expected = VehicleException.class)
	public void testEnterQueuedStateParked() throws VehicleException {
		MotorCycleTests = new MotorCycle("TEST", 1);
		MotorCycleTests.enterParkedState(20,20);
		MotorCycleTests.enterQueuedState();
	}


	
	/* ------------------------------------------------------------------------------------------ */
	
	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#exitQueuedState(int)}.
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testExitQueuedStateQueue() throws VehicleException {
		MotorCycleTests = new MotorCycle("TEST", 1);
		MotorCycleTests.enterQueuedState();
		MotorCycleTests.exitQueuedState(20);
	}
	
	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#exitQueuedState(int)}.
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test(expected = VehicleException.class)
	public void testExitQueuedStateNew() throws VehicleException {
		MotorCycleTests = new MotorCycle("TEST", 1);
		MotorCycleTests.exitQueuedState(20);
	}
	
	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#exitQueuedState(int)}.
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test(expected = VehicleException.class)
	public void testExitQueuedStateParked() throws VehicleException {
		MotorCycleTests = new MotorCycle("TEST", 1);
		MotorCycleTests.enterParkedState(20,20);
		MotorCycleTests.exitQueuedState(30);
	}
	
	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#exitQueuedState(int)}.
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test(expected = VehicleException.class)
	public void testExitQueuedStateExitTime() throws VehicleException {
		MotorCycleTests = new MotorCycle("TEST", 20);
		MotorCycleTests.enterQueuedState();
		MotorCycleTests.exitQueuedState(15);
	}

	/* ------------------------------------------------------------------------------------------ */
	
	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#enterParkedState(int, int)}.
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test (expected = VehicleException.class)
	public void testEnterParkedStateNeg() throws VehicleException {
		MotorCycleTests = new MotorCycle("TEST", 20);
		MotorCycleTests.enterParkedState(-1, 20);
	}
	
	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#enterParkedState(int, int)}.
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test (expected = VehicleException.class)
	public void testEnterParkedStateZero() throws VehicleException {
		MotorCycleTests = new MotorCycle("TEST", 20);
		MotorCycleTests.enterParkedState(0, 20);
	}
	
	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#enterParkedState(int, int)}.
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testEnterParkedStatePos() throws VehicleException {
		MotorCycleTests = new MotorCycle("TEST", 20);
		MotorCycleTests.enterParkedState(21, 20);
	}
	
	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#enterParkedState(int, int)}.
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test(expected = VehicleException.class)
	public void testEnterParkedStateLessThanMinStay() throws VehicleException {
		MotorCycleTests = new MotorCycle("TEST", 20);
		MotorCycleTests.enterParkedState(21, 19);
	}
	
	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#enterParkedState(int, int)}.
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testEnterParkedStateEqualMinStay() throws VehicleException {
		MotorCycleTests = new MotorCycle("TEST", 20);
		MotorCycleTests.enterParkedState(21, 20);
	}
	
	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#enterParkedState(int, int)}.
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testEnterParkedStateGreaterThanMinStay() throws VehicleException {
		MotorCycleTests = new MotorCycle("TEST", 20);
		MotorCycleTests.enterParkedState(21, 21);
	}
	
	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#enterParkedState(int, int)}.
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test(expected = VehicleException.class)
	public void testEnterParkedStateFromParked() throws VehicleException {
		MotorCycleTests = new MotorCycle("TEST", 20);
		MotorCycleTests.enterParkedState(21, 21);
		MotorCycleTests.enterParkedState(21, 21);
	}
	
	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#enterParkedState(int, int)}.
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test(expected = VehicleException.class)
	public void testEnterParkedStateFromQueue() throws VehicleException {
		MotorCycleTests = new MotorCycle("TEST", 20);
		MotorCycleTests.enterQueuedState();
		MotorCycleTests.enterParkedState(21, 21);
	}
	
	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#enterParkedState(int, int)}.
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testEnterParkedStateFromExitedQueue() throws VehicleException {
		MotorCycleTests = new MotorCycle("TEST", 20);
		MotorCycleTests.enterQueuedState();
		MotorCycleTests.exitQueuedState(21);
		MotorCycleTests.enterParkedState(21, 21);
	}

	/* ------------------------------------------------------------------------------------------ */
	
	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#exitParkedState()}.
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testExitParkedStateParked() throws VehicleException{
		MotorCycleTests = new MotorCycle("TEST", 20);
		MotorCycleTests.enterParkedState(21, 21);
		MotorCycleTests.exitParkedState(30);
	}
	
	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#exitParkedState()}.
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testExitParkedStateDepartureTimeEqual() throws VehicleException{
		MotorCycleTests = new MotorCycle("TEST", 20);
		MotorCycleTests.enterParkedState(21, 21);
		MotorCycleTests.exitParkedState(21);
	}
	
	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#exitParkedState()}.
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test(expected = VehicleException.class)
	public void testExitParkedStateDepartureTimeLower() throws VehicleException{
		MotorCycleTests = new MotorCycle("TEST", 20);
		MotorCycleTests.enterParkedState(21, 21);
		MotorCycleTests.exitParkedState(20);
	}
	
	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#exitParkedState()}.
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test(expected = VehicleException.class)
	public void testExitParkedStateNew() throws VehicleException{
		MotorCycleTests = new MotorCycle("TEST", 20);
		MotorCycleTests.exitParkedState(30);
	}
	
	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#exitParkedState()}.
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test(expected = VehicleException.class)
	public void testExitParkedStateQueued() throws VehicleException{
		MotorCycleTests = new MotorCycle("TEST", 20);
		MotorCycleTests.enterQueuedState();
		MotorCycleTests.exitParkedState(30);
	}
	

	/* ------------------------------------------------------------------------------------------ */
	
	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#isParked()}.
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testIsParkedParked() throws VehicleException {
		MotorCycleTests = new MotorCycle("TEST", 1);
		MotorCycleTests.enterParkedState(20, 20);
		assertTrue(MotorCycleTests.isParked());
	}
	
	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#isParked()}.
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testIsParkedNew() throws VehicleException {
		MotorCycleTests = new MotorCycle("TEST", 1);
		assertFalse(MotorCycleTests.isParked());
	}
	
	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#isParked()}.
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testIsParkedQueued() throws VehicleException {
		MotorCycleTests = new MotorCycle("TEST", 1);
		MotorCycleTests.enterQueuedState();
		assertFalse(MotorCycleTests.isParked());
	}
	
	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#isParked()}.
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testIsParkedLeftParked() throws VehicleException {
		MotorCycleTests = new MotorCycle("TEST", 1);
		MotorCycleTests.enterParkedState(20, 20);
		MotorCycleTests.exitParkedState(40);
		assertFalse(MotorCycleTests.isParked());
	}


	/* ------------------------------------------------------------------------------------------ */
	
	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#isQueued()}.
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testIsQueuedInQueue() throws VehicleException {
		MotorCycleTests = new MotorCycle("TEST", 1);
		MotorCycleTests.enterQueuedState();
		assertTrue(MotorCycleTests.isQueued());
	}
	
	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#isQueued()}.
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testIsQueuedNew() throws VehicleException {
		MotorCycleTests = new MotorCycle("TEST", 1);
		assertFalse(MotorCycleTests.isQueued());
	}
	
	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#isQueued()}.
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testIsQueuedParked() throws VehicleException {
		MotorCycleTests = new MotorCycle("TEST", 1);
		MotorCycleTests.enterParkedState(20, 20);
		assertFalse(MotorCycleTests.isQueued());
	}
	
	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#isQueued()}.
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testIsQueuedLeftParked() throws VehicleException {
		MotorCycleTests = new MotorCycle("TEST", 1);
		MotorCycleTests.enterParkedState(20, 20);
		MotorCycleTests.exitParkedState(40);
		assertFalse(MotorCycleTests.isQueued());
	}

	/* ------------------------------------------------------------------------------------------ */
	
	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#getParkingTime()}.
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testGetParkingTimeNew() throws VehicleException {
		MotorCycleTests = new MotorCycle("TEST", 1);
		assertEquals(0, MotorCycleTests.getParkingTime());
	}
	
	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#getParkingTime()}.
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testGetParkingTimeQueued() throws VehicleException {
		MotorCycleTests = new MotorCycle("TEST", 1);
		MotorCycleTests.enterQueuedState();
		assertEquals(0, MotorCycleTests.getParkingTime());
	}
	
	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#getParkingTime()}.
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testGetParkingTimeParked() throws VehicleException {
		MotorCycleTests = new MotorCycle("TEST", 1);
		MotorCycleTests.enterParkedState(20, 20);
		assertEquals(20, MotorCycleTests.getParkingTime());
	}

	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#getParkingTime()}.
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testGetParkingTimeLeftParked() throws VehicleException {
		MotorCycleTests = new MotorCycle("TEST", 1);
		MotorCycleTests.enterParkedState(20, 20);
		MotorCycleTests.exitParkedState(40);
		assertEquals(20, MotorCycleTests.getParkingTime());
	}

	/* ------------------------------------------------------------------------------------------ */
	
	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#getDepartureTime()}.
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testGetDepartureTimeNew() throws VehicleException {
		MotorCycleTests = new MotorCycle("TEST", 1);
		assertEquals(0, MotorCycleTests.getDepartureTime());
	}
	
	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#getDepartureTime()}.
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testGetDepartureTimeQueued() throws VehicleException {
		MotorCycleTests = new MotorCycle("TEST", 1);
		MotorCycleTests.enterQueuedState();
		assertEquals(0, MotorCycleTests.getDepartureTime());
	}
	
	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#getDepartureTime()}.
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testGetDepartureTimeParked() throws VehicleException {
		MotorCycleTests = new MotorCycle("TEST", 1);
		MotorCycleTests.enterParkedState(10, 20);
		assertEquals(30, MotorCycleTests.getDepartureTime());
	}
	
	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#getDepartureTime()}.
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testGetDepartureTimeActual() throws VehicleException {
		MotorCycleTests = new MotorCycle("TEST", 1);
		MotorCycleTests.enterParkedState(10, 20);
		MotorCycleTests.exitParkedState(40);
		assertEquals(40, MotorCycleTests.getDepartureTime());
	}

	/* ------------------------------------------------------------------------------------------ */
	
	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#wasQueued()}.
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testWasQueued() throws VehicleException {
		MotorCycleTests = new MotorCycle("TEST", 1);
		MotorCycleTests.enterQueuedState();
		assertTrue(MotorCycleTests.wasQueued());
	}

	/* ------------------------------------------------------------------------------------------ */
	
	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#wasParked()}.
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testWasParked() throws VehicleException{
		MotorCycleTests = new MotorCycle("TEST", 1);
		MotorCycleTests.enterParkedState(20, 20);
		assertTrue(MotorCycleTests.wasParked());
	}

	/* ------------------------------------------------------------------------------------------ */
	
	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#isSatisfied()}.
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testIsSatisfiedNew() throws VehicleException{
		MotorCycleTests = new MotorCycle("TEST", 1);
		assertTrue(MotorCycleTests.isSatisfied());
	}
	
	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#isSatisfied()}.
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testIsSatisfiedParked() throws VehicleException{
		MotorCycleTests = new MotorCycle("TEST", 1);
		MotorCycleTests.enterParkedState(20, 20);
		assertTrue(MotorCycleTests.isSatisfied());
	}
	
	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#isSatisfied()}.
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testIsSatisfiedQueued() throws VehicleException {
		MotorCycleTests = new MotorCycle("TEST", 1);
		MotorCycleTests.enterQueuedState();
		assertTrue(MotorCycleTests.isSatisfied());
	}
	
	/**
	 * Test method for {@link asgn2Vehicles.Vehicle#isSatisfied()}.
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testIsSatisfiedLeftPark() throws VehicleException {
		MotorCycleTests = new MotorCycle("TEST", 1);
		MotorCycleTests.enterParkedState(20, 20);
		MotorCycleTests.exitParkedState(40);
		assertTrue(MotorCycleTests.isSatisfied());
	}

	

	/* End of Vehicle tests */
	
	/* ------------------------------------------------------------------------------------------ */
}
