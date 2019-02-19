package Vero;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HelloWorldTest {

	@Test
	void testSayHello() {
		HelloWorld hello = new HelloWorld();
		String answer = hello.sayHello(); 
		assertEquals("Hello World", answer);
	}

}
