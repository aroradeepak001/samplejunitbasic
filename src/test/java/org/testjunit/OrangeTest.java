package org.testjunit;



import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Orange.class,Apple.class})
public class OrangeTest {
	Apple MockApple;
	
	
	@Before
	public void setup() throws IllegalArgumentException, IllegalAccessException{
		
		MockApple = Mockito.mock(Apple.class);
		
		Mockito.when(MockApple.getType()).thenReturn("Orange");
		
		PowerMockito.mock(Orange.class);
		
		PowerMockito.field(Orange.class, "apple").set(Orange.class, MockApple);
	
	}
	
	@Test
	public void firstJunit(){
		
		assertTrue(Orange.getApple().getType().equals("Orange"));
	}
	
}
