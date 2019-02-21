package Vero;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.mockito.ArgumentMatchers;
import static org.mockito.Matchers.*;

@ExtendWith(MockitoExtension.class)

public class GreetingServiceTest {
	
	@Mock 
	private Hello helloMock;
	@InjectMocks
    private GreetingService greeting;
	
	@Test
	@DisplayName("Test 1 Greet")
	public void testGreet() {
		// prepare mock
		Mockito.when(helloMock.sayHello("World"))
	           .thenReturn("Hello World");
		// execute test
		String answer = greeting.greet("World");
		assertEquals("Greeting message: Hello World", answer);
	}
	
	@Test
	@DisplayName("Test 2 Greet Null")
	public void testGreetNull() {
		// prepare mock
		Mockito.when(helloMock.sayHello(null))
	           .thenThrow(new NullPointerException());
		// execute test
		assertThrows(NullPointerException.class,
					() -> greeting.greet(null));
	}
	
	@Test
	@DisplayName("Test 3 Greet Answer")
	public void testGreetAnswer() {
		// prepare mock
		Mockito.when(helloMock.sayHello("World"))
	           .then(new Answer<String>() {
				   public String answer(InvocationOnMock invocation){
					   String arg = invocation.getArgument(0);
					   return "Hello " + arg;
				   }
			   });
			   
		// execute test
		String answer = greeting.greet("World");
		assertEquals("Greeting message: Hello World", answer);
	}
	
	@Test
	@DisplayName("Test 4 Greet Answer Lambda")
	public void testGreetAnswerLambda() {
		// prepare mock
		Mockito.when(helloMock.sayHello("World"))
	           .then(inv -> "Hello " + inv.getArgument(0));
			   
		// execute test
		String answer = greeting.greet("World");
		assertEquals("Greeting message: Hello World", answer);
	}

	@Test
	@DisplayName("Test 5 Greet Multiple")
	public void testGreetMultiple() {
		// prepare mock
		Mockito.when(helloMock.sayHello("World"))
	           .thenReturn("Hello World", "Goodbye World");
		// execute test
		String answer = greeting.greet("World");
		assertEquals("Greeting message: Hello World", answer);
		answer = greeting.greet("World");
		assertEquals("Greeting message: Goodbye World", answer);
	}
	
	@Test
	@DisplayName("Test 6 Greet Matcher")
	public void testGreetMatcher() {
		// prepare mock
		Mockito.when(helloMock.sayHello(ArgumentMatchers.any()))
	           .then(new Answer<String>() {
				   public String answer(InvocationOnMock invocation){
					   String arg = invocation.getArgument(0);
					   return "Hello " + arg;
				   }
			   });
		// execute test
		String answer = greeting.greet("Homer");
		assertEquals("Greeting message: Hello Homer", answer);
	}
	
	@Test
	@DisplayName("Test 7 Greet Void")
	@Disabled("Error")
	public void testGreetVoid() {
		// prepare mock
		Mockito.doThrow(NullPointerException.class)
 			   .when(helloMock).sayHello(null);
		// execute test
		greeting.greet(null);
	}
	
	@Test
	@DisplayName("Test 8 Greet verify")
	public void testGreetVerify() {
		// prepare mock
		Mockito.when(helloMock.sayHello("World"))
	           .thenReturn("Hello World");
		// execute test
		greeting.greet("World");
		// verify mock
		Mockito.verify(helloMock).sayHello("World");
	}
	
	@Test
	@DisplayName("Test 9 Greet verify x times")
	public void testGreetVerifyXTimes() {
		// prepare mock
		Mockito.when(helloMock.sayHello("World"))
	           .thenReturn("Hello World");
		// execute test
		greeting.greet("World");
		greeting.greet("World");
		// verify mock
		Mockito.verify(helloMock,Mockito.times(2)).sayHello("World");
	}
	
	@Test
	@DisplayName("Test 10 Greet verify order")
	public void testGreetVerifyOrder() {
		// prepare mock
		Mockito.when(helloMock.sayHello("World"))
	           .thenReturn("Hello World");
		// execute test
		greeting.greet("World");
		greeting.greet("Mars");
		// verify mock
		InOrder inOrder = Mockito.inOrder(helloMock);
		inOrder.verify(helloMock).sayHello("World");
		inOrder.verify(helloMock).sayHello("Mars");
	}
	
	@Test
	@DisplayName("Test 11 Greet verify Arguments")
	//@Disabled("Error op any")
	public void testGreetVerifyArguments() {
		// prepare mock
		Mockito.when(helloMock.sayHello(any()))
	           .then(inv -> "Hello " + inv.getArgument(0));
		// execute test
		greeting.greet("Moon");
		// verify mock
		Mockito.verify(helloMock).sayHello(any());
	}
	 
	@Test
	@DisplayName("Test 12 Greet verify Time")
	//@Disabled("Error op any")
	public void testGreetVerifyTime() {
		// prepare mock
		Mockito.when(helloMock.sayHello("World"))
	           .thenReturn("Hello World");
		// execute test
		greeting.greet("World");
		// verify mock
		Mockito.verify(helloMock,Mockito.timeout(10)).sayHello("World");
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