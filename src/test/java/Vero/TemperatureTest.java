package Vero;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)

class TemperatureTest {
	
	Temperature t = new Temperature();
	
	@BeforeAll
	@DisplayName ("temp op 0 zetten")
	void Init() {
		t.setTemperature(0); 
	}

	@Test
	@DisplayName ("test op Temperature init uit class Temperature")
	void testTemperature() {
		Float answer = t.temp(); 
		assertEquals(20,0, answer);
	}

	@Test
	@DisplayName ("test op Set en Get")
	void testSetT() {
		t.setTemperature(23); 
		Float answer = t.getTemperature(); 
		assertEquals(23,0, answer);
	}

	@Test
	@DisplayName ("test op koken")
	void testIsBoiling() {
		Boolean answer1 = t.isBoiling(123); 
		assertEquals(true, answer1);
	}
	
	@Test
	@DisplayName ("test op vriezen")
	void testIsFreezing() {
		Boolean answer1 = t.isFreezing(-1); 
		assertEquals(true, answer1);
	}
	
	@Test
	@DisplayName ("test op Equals")
	@Disabled ("Not implemented")
	void testEqualsObject() {
		fail("Not yet implemented");
	}

	@Test
	@DisplayName ("test op HashCode")
	@Disabled ("Not implemented")
	void testHashCode() {
		fail("Not yet implemented");
	}
}
