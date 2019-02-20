package Vero;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)

public class GreetingServiceTest {
	
	@Mock 
	private Hello helloMock;
	@InjectMocks
    private GreetingService greeting;
	
	@Test
	public void testGreet() {
		// prepare mock
		Mockito.when(helloMock.sayHello("World"))
	           .thenReturn("Hello World");
		// execute test
		String answer = greeting.greet("World");
		assertEquals("Greeting message: Hello World", answer);
	}

}


/* werkwijze zonder Mockito Extension 
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import org.mockito.Mockito;

 @TestInstance(Lifecycle.PER_CLASS)

public class GreetingServiceTest {
	
	private GreetingService greeting;
	private Hello helloMock;
			
	@BeforeEach
	public void beforeTest() {
		helloMock = Mockito.mock(Hello.class);
		greeting = new GreetingService(helloMock);
	}
	
	@Test
	public void testGreet() {
		// prepare mock
		Mockito.when(helloMock.sayHello("World"))
	           .thenReturn("Hello World");
		// execute test
		String answer = greeting.greet("World");
		assertEquals("Greeting message: Hello World", answer);
	}

}
*/