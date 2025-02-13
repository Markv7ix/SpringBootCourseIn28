/**
 * 
 */
package com.modernjava.sealed;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 */
class VehicleTest {

	@Test
	void vehicleTest() {
		var car = new Car();
		var truck = new Truck();
		assertInstanceOf(Vehicle.class, car);
		assertInstanceOf(Vehicle.class, truck);
	}

}
