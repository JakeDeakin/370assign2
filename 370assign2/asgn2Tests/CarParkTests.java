/**
 * 
 * This file is part of the CarParkSimulator Project, written as 
 * part of the assessment for INB370, semester 1, 2014. 
 *
 * CarParkSimulator
 * asgn2Tests 
 * 29/04/2014
 * 
 */
package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import asgn2CarParks.CarPark;
import asgn2Exceptions.SimulationException;
import asgn2Exceptions.VehicleException;
import asgn2Vehicles.Car;
import asgn2Vehicles.Vehicle;

/**
 * @author hogan
 *
 */
public class CarParkTests {
		private CarPark carParkTests;
		private Car car;
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

	/*---------------------------------------------------------------------------------------------------*/
	
	/**
	 * Test method for {@link asgn2CarParks.CarPark#archiveDepartingVehicles(int, boolean)}.
	 * 
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test(expected = SimulationException.class)
	public void testArchiveDepartingVehicles() throws SimulationException, VehicleException{
		carParkTests = new CarPark();
		carParkTests.archiveDepartingVehicles(100,true);
	}
	
	/*---------------------------------------------------------------------------------------------------*/

	/**
	 * Test method for {@link asgn2CarParks.CarPark#archiveNewVehicle(asgn2Vehicles.Vehicle)}.
	 * 
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testArchiveNewVehicleGoodInput()  throws SimulationException, VehicleException{
		carParkTests = new CarPark();
		car = new Car("TEST", 100, true);
		carParkTests.archiveNewVehicle(car);
	}
	
	/**
	 * Test method for {@link asgn2CarParks.CarPark#archiveNewVehicle(asgn2Vehicles.Vehicle)}.
	 * 
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test (expected = SimulationException.class)
	public void testArchiveNewVehicleParked()  throws SimulationException, VehicleException{
		carParkTests = new CarPark();
		car = new Car("TEST", 100, true);
		car.enterParkedState(100, 20);
		carParkTests.archiveNewVehicle(car);
	}
	
	/**
	 * Test method for {@link asgn2CarParks.CarPark#archiveNewVehicle(asgn2Vehicles.Vehicle)}.
	 * 
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test (expected = SimulationException.class)
	public void testArchiveNewVehicleQueued()  throws SimulationException, VehicleException{
		carParkTests = new CarPark();
		car = new Car("TEST", 100, true);
		car.enterQueuedState();
		carParkTests.archiveNewVehicle(car);
	}
	
	/*---------------------------------------------------------------------------------------------------*/
	/**
	 * Test method for {@link asgn2CarParks.CarPark#archiveQueueFailures(int)}.
	 * 
	 * @author Jake n8509956 and Jamie n8853312
	 * @throws SimulationException 
	 */
	@Test
	public void testArchiveQueueFailures() throws VehicleException, SimulationException {
		carParkTests = new CarPark();
		car = new Car("TEST", 100, true);
		carParkTests.archiveQueueFailures(100);
	}
	
	
	/**
	 * Test method for {@link asgn2CarParks.CarPark#archiveQueueFailures(int)}.
	 * 
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testArchiveQueueFailuresTime() throws VehicleException, SimulationException {
		carParkTests = new CarPark();
		car = new Car("TEST", 100, true);
		carParkTests.archiveQueueFailures(127);
	}

	/*---------------------------------------------------------------------------------------------------*/
	
	/**
	 * Test method for {@link asgn2CarParks.CarPark#carParkEmpty()}.
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testCarParkEmpty() {
		carParkTests = new CarPark();
		assertTrue(carParkTests.carParkEmpty());
	}

	
	/*---------------------------------------------------------------------------------------------------*/
	
	/**
	 * Test method for {@link asgn2CarParks.CarPark#carParkFull()}.
	 */
	@Test
	public void testCarParkFull() {
		fail("Not yet implemented"); //TODO
	}
	
	/*---------------------------------------------------------------------------------------------------*/
	
	/**
	 * Test method for {@link asgn2CarParks.CarPark#enterQueue(asgn2Vehicles.Vehicle)}.
	 * 
	 */
	@Test
	public void testEnterQueue() throws SimulationException, VehicleException {
		carParkTests = new CarPark();
		car = new Car("TEST", 100, true);
		carParkTests.enterQueue(car);
	}

	/*---------------------------------------------------------------------------------------------------*/
	
	/**
	 * Test method for {@link asgn2CarParks.CarPark#exitQueue(asgn2Vehicles.Vehicle, int)}.
	 */
	@Test
	public void testExitQueue() throws SimulationException, VehicleException {
		carParkTests = new CarPark();
		car = new Car("TEST", 100, true);
		carParkTests.enterQueue(car);
		carParkTests.exitQueue(car, 120);
	}
	
	/**
	 * Test method for {@link asgn2CarParks.CarPark#exitQueue(asgn2Vehicles.Vehicle, int)}.
	 */
	@Test (expected = SimulationException.class)
	public void testExitQueueNotQueued() throws SimulationException, VehicleException {
		carParkTests = new CarPark();
		car = new Car("TEST", 100, true);
		carParkTests.exitQueue(car, 120);
	}
	
	/*---------------------------------------------------------------------------------------------------*/

	/**
	 * Test method for {@link asgn2CarParks.CarPark#getNumCars()}.
	 */
	@Test
	public void testGetNumCarsZero() {
		carParkTests = new CarPark();
		assertEquals(0, carParkTests.getNumCars());
	}
		
	/*---------------------------------------------------------------------------------------------------*/
	
	/**
	 * Test method for {@link asgn2CarParks.CarPark#getNumMotorCycles()}.
	 */
	@Test
	public void testGetNumMotorCyclesZero() {
		carParkTests = new CarPark();
		assertEquals(0, carParkTests.getNumMotorCycles());
	}
	
	/*---------------------------------------------------------------------------------------------------*/

	/**
	 * Test method for {@link asgn2CarParks.CarPark#getNumSmallCars()}.
	 */
	@Test
	public void testGetNumSmallCarsZero() {
		carParkTests = new CarPark();
		assertEquals(0, carParkTests.getNumSmallCars());
	}
	
	/*---------------------------------------------------------------------------------------------------*/

	/**
	 * Test method for {@link asgn2CarParks.CarPark#numVehiclesInQueue()}.
	 */
	@Test
	public void testNumVehiclesInQueueZero() {
		carParkTests = new CarPark();
		assertEquals(0, carParkTests.numVehiclesInQueue());
	}
	
	/**
	 * Test method for {@link asgn2CarParks.CarPark#numVehiclesInQueue()}.
	 * 
	 */
	@Test
	public void testNumVehiclesInQueueOne() throws VehicleException, SimulationException {
		carParkTests = new CarPark();
		car = new Car("TEST", 100, true);
		carParkTests.enterQueue(car);
		assertEquals(1, carParkTests.numVehiclesInQueue());
	}

	/*---------------------------------------------------------------------------------------------------*/
	
	/**
	 * Test method for {@link asgn2CarParks.CarPark#parkVehicle(asgn2Vehicles.Vehicle, int, int)}.
	 * 
	 */
	@Test
	public void testParkVehicle() throws VehicleException, SimulationException {
		carParkTests = new CarPark();
		car = new Car("TEST", 100, true);
		carParkTests.parkVehicle(car, 110, 20);
	}
	
	/**
	 * Test method for {@link asgn2CarParks.CarPark#parkVehicle(asgn2Vehicles.Vehicle, int, int)}.
	 * 
	 */
	@Test (expected = VehicleException.class)
	public void testParkVehicleParked() throws VehicleException, SimulationException {
		carParkTests = new CarPark();
		car = new Car("TEST", 100, true);
		car.enterParkedState(110, 20);
		carParkTests.parkVehicle(car, 110, 20);
	}
	
	/**
	 * Test method for {@link asgn2CarParks.CarPark#parkVehicle(asgn2Vehicles.Vehicle, int, int)}.
	 * 
	 */
	@Test (expected = VehicleException.class)
	public void testParkVehicleQueued() throws VehicleException, SimulationException {
		carParkTests = new CarPark();
		car = new Car("TEST", 100, true);
		car.enterQueuedState();
		carParkTests.parkVehicle(car, 110, 20);
	}

	/*---------------------------------------------------------------------------------------------------*/
	
	/**
	 * Test method for {@link asgn2CarParks.CarPark#processQueue(int, asgn2Simulators.Simulator)}.
	 */
	@Test
	public void testProcessQueue() {
		fail("Not yet implemented"); // TODO
	}

	/*---------------------------------------------------------------------------------------------------*/
	
	/**
	 * Test method for {@link asgn2CarParks.CarPark#queueEmpty()}.
	 */
	@Test
	public void testQueueEmpty() {
		carParkTests = new CarPark();
		assertTrue(carParkTests.queueEmpty());
	}

	/*---------------------------------------------------------------------------------------------------*/
	
	/**
	 * Test method for {@link asgn2CarParks.CarPark#queueFull()}.
	 */
	@Test
	public void testQueueFull() {
		fail("Not yet implemented"); // TODO
	}

	/*---------------------------------------------------------------------------------------------------*/
	
	/**
	 * Test method for {@link asgn2CarParks.CarPark#spacesAvailable(asgn2Vehicles.Vehicle)}.
	 * 
	 */
	@Test
	public void testSpacesAvailable() throws VehicleException {
		carParkTests = new CarPark();
		assertTrue(carParkTests.spacesAvailable(car));
	}

	/*---------------------------------------------------------------------------------------------------*/

	/**
	 * Test method for {@link asgn2CarParks.CarPark#tryProcessNewVehicles(int, asgn2Simulators.Simulator)}.
	 */
	@Test
	public void testTryProcessNewVehicles() {
		fail("Not yet implemented"); // TODO
	}

	/*---------------------------------------------------------------------------------------------------*/
	
	/**
	 * Test method for {@link asgn2CarParks.CarPark#unparkVehicle(asgn2Vehicles.Vehicle, int)}.
	 *  
	 */
	@Test
	public void testUnparkVehicle() throws VehicleException, SimulationException {
		carParkTests = new CarPark();
		car = new Car("TEST", 100, true);
		carParkTests.parkVehicle(car, 110, 20);
		carParkTests.unparkVehicle(car, 130);
	}
	
	/**
	 * Test method for {@link asgn2CarParks.CarPark#unparkVehicle(asgn2Vehicles.Vehicle, int)}.
	 *  
	 */
	@Test (expected = VehicleException.class)
	public void testUnparkVehicleNotParked() throws VehicleException, SimulationException {
		carParkTests = new CarPark();
		car = new Car("TEST", 100, true);
		carParkTests.parkVehicle(car, 110, 20);
		car.exitParkedState(130);
		carParkTests.unparkVehicle(car, 130);
	}

}
