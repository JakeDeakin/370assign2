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
import asgn2Simulators.Constants;
import asgn2Simulators.Simulator;
import asgn2Vehicles.Car;
import asgn2Vehicles.MotorCycle;

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
	 * Test method for
	 * {@link asgn2CarParks.CarPark#archiveDepartingVehicles(int, boolean)}.
	 * 
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test(expected = SimulationException.class)
	public void testArchiveDepartingVehicles() throws SimulationException,
			VehicleException {
		carParkTests = new CarPark();
		carParkTests.archiveDepartingVehicles(100, true);
	}

	/*---------------------------------------------------------------------------------------------------*/

	/**
	 * Test method for
	 * {@link asgn2CarParks.CarPark#archiveNewVehicle(asgn2Vehicles.Vehicle)}.
	 * 
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testArchiveNewVehicleGoodInput() throws SimulationException,
			VehicleException {
		carParkTests = new CarPark();
		car = new Car("TEST", 100, true);
		carParkTests.archiveNewVehicle(car);
	}

	/**
	 * Test method for
	 * {@link asgn2CarParks.CarPark#archiveNewVehicle(asgn2Vehicles.Vehicle)}.
	 * 
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test(expected = SimulationException.class)
	public void testArchiveNewVehicleParked() throws SimulationException,
			VehicleException {
		carParkTests = new CarPark();
		car = new Car("TEST", 100, true);
		car.enterParkedState(100, 20);
		carParkTests.archiveNewVehicle(car);
	}

	/**
	 * Test method for
	 * {@link asgn2CarParks.CarPark#archiveNewVehicle(asgn2Vehicles.Vehicle)}.
	 * 
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test(expected = SimulationException.class)
	public void testArchiveNewVehicleQueued() throws SimulationException,
			VehicleException {
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
	 */
	@Test
	public void testArchiveQueueFailures() throws VehicleException,
			SimulationException {
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
	public void testArchiveQueueFailuresTime() throws VehicleException,
			SimulationException {
		carParkTests = new CarPark();
		car = new Car("TEST", 100, true);
		carParkTests.archiveQueueFailures(127);
	}

	/*---------------------------------------------------------------------------------------------------*/

	/**
	 * Test method for {@link asgn2CarParks.CarPark#carParkEmpty()}.
	 * 
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testCarParkEmpty() {
		carParkTests = new CarPark();
		assertTrue(carParkTests.carParkEmpty());
	}

	/**
	 * Test method for {@link asgn2CarParks.CarPark#carParkEmpty()}.
	 * 
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testCarParkEmptyFalse() throws VehicleException,
			SimulationException {
		carParkTests = new CarPark();
		car = new Car("TEST", 100, true);
		carParkTests.parkVehicle(car, 100, 120);
		assertFalse(carParkTests.carParkEmpty());
	}

	/*---------------------------------------------------------------------------------------------------*/

	/**
	 * Test method for {@link asgn2CarParks.CarPark#carParkFull()}.
	 */
	@Test
	public void testCarParkFullTrue() throws SimulationException,
			VehicleException {
		carParkTests = new CarPark();

		for (int i = 0; i < Constants.DEFAULT_MAX_CAR_SPACES; i++) {
			Car c = new Car("TEST", 120, true);
			carParkTests.parkVehicle(c, 120, 140);
		}

		for (int i = 0; i < Constants.DEFAULT_MAX_MOTORCYCLE_SPACES; i++) {
			MotorCycle m = new MotorCycle("TEST", 120);
			carParkTests.parkVehicle(m, 120, 140);
		}
		assertTrue(carParkTests.carParkFull());

	}

	/**
	 * Test method for {@link asgn2CarParks.CarPark#carParkFull()}.
	 */
	@Test
	public void testCarParkFullFalse() throws SimulationException,
			VehicleException {
		carParkTests = new CarPark();

		for (int i = 0; i < Constants.DEFAULT_MAX_CAR_SPACES; i++) {
			Car c = new Car("TEST", 120, true);
			carParkTests.parkVehicle(c, 120, 140);
		}

		assertFalse(carParkTests.carParkFull());

	}

	/*---------------------------------------------------------------------------------------------------*/

	/**
	 * Test method for
	 * {@link asgn2CarParks.CarPark#enterQueue(asgn2Vehicles.Vehicle)}.
	 * 
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testEnterQueue() throws SimulationException, VehicleException {
		carParkTests = new CarPark();
		car = new Car("TEST", 100, true);
		carParkTests.enterQueue(car);
	}

	/*---------------------------------------------------------------------------------------------------*/

	/**
	 * Test method for
	 * {@link asgn2CarParks.CarPark#exitQueue(asgn2Vehicles.Vehicle, int)}.
	 * 
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testExitQueue() throws SimulationException, VehicleException {
		carParkTests = new CarPark();
		car = new Car("TEST", 100, true);
		carParkTests.enterQueue(car);
		carParkTests.exitQueue(car, 120);
	}

	/**
	 * Test method for
	 * {@link asgn2CarParks.CarPark#exitQueue(asgn2Vehicles.Vehicle, int)}.
	 * 
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test(expected = SimulationException.class)
	public void testExitQueueNotQueued() throws SimulationException,
			VehicleException {
		carParkTests = new CarPark();
		car = new Car("TEST", 100, true);
		carParkTests.exitQueue(car, 120);
	}

	/*---------------------------------------------------------------------------------------------------*/

	/**
	 * Test method for {@link asgn2CarParks.CarPark#getNumCars()}.
	 * 
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testGetNumCarsZero() {
		carParkTests = new CarPark();
		assertEquals(0, carParkTests.getNumCars());
	}

	/**
	 * Test method for {@link asgn2CarParks.CarPark#getNumCars()}.
	 * 
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testGetNumCarsTen() throws VehicleException, SimulationException {
		carParkTests = new CarPark();
		Simulator sim = new Simulator();
		carParkTests.tryProcessNewVehicles(120, sim);
		carParkTests.tryProcessNewVehicles(120, sim);
		carParkTests.tryProcessNewVehicles(120, sim);
		carParkTests.tryProcessNewVehicles(120, sim);
		carParkTests.tryProcessNewVehicles(120, sim);
		carParkTests.tryProcessNewVehicles(120, sim);
		carParkTests.tryProcessNewVehicles(120, sim);
		carParkTests.tryProcessNewVehicles(120, sim);
		carParkTests.tryProcessNewVehicles(120, sim);
		carParkTests.tryProcessNewVehicles(120, sim);
		assertEquals(10, carParkTests.getNumCars());
	}
	
	
	/*---------------------------------------------------------------------------------------------------*/

	/**
	 * Test method for {@link asgn2CarParks.CarPark#getNumMotorCycles()}.
	 * 
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testGetNumMotorCyclesZero() {
		carParkTests = new CarPark();
		assertEquals(0, carParkTests.getNumMotorCycles());
	}

	/*---------------------------------------------------------------------------------------------------*/

	/**
	 * Test method for {@link asgn2CarParks.CarPark#getNumSmallCars()}.
	 * 
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testGetNumSmallCarsZero() {
		carParkTests = new CarPark();
		assertEquals(0, carParkTests.getNumSmallCars());
	}

	/*---------------------------------------------------------------------------------------------------*/

	/**
	 * Test method for {@link asgn2CarParks.CarPark#numVehiclesInQueue()}.
	 * 
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testNumVehiclesInQueueZero() {
		carParkTests = new CarPark();
		assertEquals(0, carParkTests.numVehiclesInQueue());
	}

	/**
	 * Test method for {@link asgn2CarParks.CarPark#numVehiclesInQueue()}.
	 * 
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testNumVehiclesInQueueOne() throws VehicleException,
			SimulationException {
		carParkTests = new CarPark();
		car = new Car("TEST", 100, true);
		carParkTests.enterQueue(car);
		assertEquals(1, carParkTests.numVehiclesInQueue());
	}

	/*---------------------------------------------------------------------------------------------------*/

	/**
	 * Test method for
	 * {@link asgn2CarParks.CarPark#parkVehicle(asgn2Vehicles.Vehicle, int, int)}
	 * .
	 * 
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testParkVehicle() throws VehicleException, SimulationException {
		carParkTests = new CarPark();
		car = new Car("TEST", 100, true);
		carParkTests.parkVehicle(car, 110, 20);
	}

	/**
	 * Test method for
	 * {@link asgn2CarParks.CarPark#parkVehicle(asgn2Vehicles.Vehicle, int, int)}
	 * .
	 * 
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test(expected = VehicleException.class)
	public void testParkVehicleParked() throws VehicleException,
			SimulationException {
		carParkTests = new CarPark();
		car = new Car("TEST", 100, true);
		car.enterParkedState(110, 20);
		carParkTests.parkVehicle(car, 110, 20);
	}

	/**
	 * Test method for
	 * {@link asgn2CarParks.CarPark#parkVehicle(asgn2Vehicles.Vehicle, int, int)}
	 * .
	 * 
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test(expected = VehicleException.class)
	public void testParkVehicleQueued() throws VehicleException,
			SimulationException {
		carParkTests = new CarPark();
		car = new Car("TEST", 100, true);
		car.enterQueuedState();
		carParkTests.parkVehicle(car, 110, 20);
	}

	/*---------------------------------------------------------------------------------------------------*/

	/**
	 * Test method for
	 * {@link asgn2CarParks.CarPark#processQueue(int, asgn2Simulators.Simulator)}
	 * .
	 */
	@Test
	public void testProcessQueueEmptyPark() throws VehicleException,
			SimulationException {
		carParkTests = new CarPark();
		Simulator sim = new Simulator();

		for (int i = 0; i < Constants.DEFAULT_MAX_QUEUE_SIZE; i++) {
			Car c = new Car("TEST", 120, true);
			carParkTests.enterQueue(c);
		}
		carParkTests.processQueue(120, sim);
	}

	/**
	 * Test method for
	 * {@link asgn2CarParks.CarPark#processQueue(int, asgn2Simulators.Simulator)}
	 * .
	 */

	@Test(expected = VehicleException.class)
	public void testProcessQueueNotQueued() throws VehicleException,
			SimulationException {
		carParkTests = new CarPark();
		Simulator sim = new Simulator();

		Car c = new Car("TEST", 120, true);
		carParkTests.enterQueue(c);
		c.exitQueuedState(120);

		carParkTests.processQueue(120, sim);
	}

	/**
	 * Test method for
	 * {@link asgn2CarParks.CarPark#processQueue(int, asgn2Simulators.Simulator)}
	 * .
	 */

	@Test(expected = VehicleException.class)
	public void testProcessQueueTime() throws VehicleException,
			SimulationException {
		carParkTests = new CarPark();
		Simulator sim = new Simulator();

		Car c = new Car("TEST", 120, true);
		carParkTests.enterQueue(c);

		carParkTests.processQueue(110, sim);
	}

	/**
	 * Test method for
	 * {@link asgn2CarParks.CarPark#processQueue(int, asgn2Simulators.Simulator)}
	 * .
	 */
	@Test
	public void testProcessQueueFullPark() throws VehicleException,
			SimulationException {
		carParkTests = new CarPark();
		Simulator sim = new Simulator();

		for (int i = 0; i < Constants.DEFAULT_MAX_CAR_SPACES; i++) {
			Car c = new Car("TEST", 120, true);
			carParkTests.parkVehicle(c, 120, 140);
		}
		
		Car car = new Car("Test", 125, true);
		carParkTests.enterQueue(car);
		carParkTests.processQueue(130, sim);
		assertTrue(car.isQueued());
		
	}
	
	/**
	 * Test method for
	 * {@link asgn2CarParks.CarPark#processQueue(int, asgn2Simulators.Simulator)}
	 * .
	 */
	@Test
	public void testProcessQueueOverTime() throws VehicleException,
			SimulationException {
		carParkTests = new CarPark();
		Simulator sim = new Simulator();
		Car car = new Car("Test", 250, true);
		carParkTests.enterQueue(car);
		carParkTests.archiveQueueFailures(275);
		assertFalse(car.isParked());
		
	}

	/*---------------------------------------------------------------------------------------------------*/

	/**
	 * Test method for {@link asgn2CarParks.CarPark#queueEmpty()}.
	 * 
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testQueueEmpty() {
		carParkTests = new CarPark();
		assertTrue(carParkTests.queueEmpty());
	}

	/*---------------------------------------------------------------------------------------------------*/

	/**
	 * Test method for {@link asgn2CarParks.CarPark#queueFull()}.
	 * 
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testQueueFullOneCar() throws VehicleException,
			SimulationException {
		carParkTests = new CarPark();
		Car c = new Car("TEST", 120, true);
		carParkTests.enterQueue(c);
		assertFalse(carParkTests.queueFull());
	}

	/**
	 * Test method for {@link asgn2CarParks.CarPark#queueFull()}.
	 * 
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testQueueFullEmpty() throws VehicleException,
			SimulationException {
		carParkTests = new CarPark();
		assertFalse(carParkTests.queueFull());
	}

	/**
	 * Test method for {@link asgn2CarParks.CarPark#queueFull()}.
	 * 
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testQueueFullFull() throws VehicleException,
			SimulationException {
		carParkTests = new CarPark();

		for (int i = 0; i < Constants.DEFAULT_MAX_QUEUE_SIZE; i++) {
			Car c = new Car("TEST", 120, true);
			carParkTests.enterQueue(c);
		}
		assertTrue(carParkTests.queueFull());

	}

	/*---------------------------------------------------------------------------------------------------*/

	/**
	 * Test method for
	 * {@link asgn2CarParks.CarPark#spacesAvailable(asgn2Vehicles.Vehicle)}.
	 * 
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testSpacesAvailable() throws VehicleException {
		carParkTests = new CarPark();
		assertTrue(carParkTests.spacesAvailable(car));
	}

	/*---------------------------------------------------------------------------------------------------*/

	/**
	 * Test method for
	 * {@link asgn2CarParks.CarPark#tryProcessNewVehicles(int, asgn2Simulators.Simulator)}
	 * .
	 */
	@Test
	public void testTryProcessNewVehiclesEmptyPark() throws VehicleException,
			SimulationException {
		carParkTests = new CarPark();
		Simulator sim = new Simulator();

		carParkTests.tryProcessNewVehicles(100, sim);
		assertFalse(carParkTests.carParkEmpty());
	}

	/**
	 * Test method for
	 * {@link asgn2CarParks.CarPark#tryProcessNewVehicles(int, asgn2Simulators.Simulator)}
	 * .
	 */
	@Test
	public void testTryProcessNewVehiclesFullPark() throws VehicleException,
			SimulationException {
		carParkTests = new CarPark();
		Simulator sim = new Simulator();

		for (int i = 0; i < Constants.DEFAULT_MAX_CAR_SPACES; i++) {
			Car c = new Car("TEST", 120, true);
			carParkTests.parkVehicle(c, 120, 140);
		}
		
		for (int i = 0; i < Constants.DEFAULT_MAX_MOTORCYCLE_SPACES; i++) {
			MotorCycle m = new MotorCycle("TEST", 120);
			carParkTests.parkVehicle(m, 120, 140);
		}

		carParkTests.tryProcessNewVehicles(150, sim);
		assertFalse(carParkTests.queueEmpty());
	}

	/**
	 * Test method for
	 * {@link asgn2CarParks.CarPark#tryProcessNewVehicles(int, asgn2Simulators.Simulator)}
	 * .
	 */
	@Test(expected = SimulationException.class)
	public void testTryProcessNewVehiclesFullParkQueue()
			throws VehicleException, SimulationException {

		carParkTests = new CarPark();
		Simulator sim = new Simulator();

		for (int i = 0; i < Constants.DEFAULT_MAX_CAR_SPACES; i++) {
			Car c = new Car("TEST", 120, true);
			carParkTests.parkVehicle(c, 120, 140);
		}
		
		for (int i = 0; i < Constants.DEFAULT_MAX_MOTORCYCLE_SPACES; i++) {
			MotorCycle m = new MotorCycle("TEST", 120);
			carParkTests.parkVehicle(m, 120, 140);
		}

		for (int i = 0; i < Constants.DEFAULT_MAX_QUEUE_SIZE; i++) {
			Car c = new Car("TEST", 120, true);
			carParkTests.enterQueue(c);
		}

		carParkTests.tryProcessNewVehicles(150, sim);

	}

	/*---------------------------------------------------------------------------------------------------*/

	/**
	 * Test method for
	 * {@link asgn2CarParks.CarPark#unparkVehicle(asgn2Vehicles.Vehicle, int)}.
	 * 
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test
	public void testUnparkVehicle() throws VehicleException,
			SimulationException {
		carParkTests = new CarPark();
		car = new Car("TEST", 100, true);
		carParkTests.parkVehicle(car, 110, 20);
		carParkTests.unparkVehicle(car, 130);
	}

	/**
	 * Test method for
	 * {@link asgn2CarParks.CarPark#unparkVehicle(asgn2Vehicles.Vehicle, int)}.
	 * 
	 * @author Jake n8509956 and Jamie n8853312
	 */
	@Test(expected = VehicleException.class)
	public void testUnparkVehicleNotParked() throws VehicleException,
			SimulationException {
		carParkTests = new CarPark();
		car = new Car("TEST", 100, true);
		carParkTests.parkVehicle(car, 110, 20);
		car.exitParkedState(130);
		carParkTests.unparkVehicle(car, 130);
	}

}
