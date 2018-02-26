package mandatory_assignment_4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Mandatory_Assignment_4Test {
	
	Token_1 token;
	
	@Before
	public void CreateToken() {
		token =  new Token_1();
	}

	@Test
	public void testEnterCoordinates() {
		token.x1 = 1;
		token.y1 = 2;
		assertEquals(1, token.x1);
		assertEquals(2, token.y1);
	}
	
	@Test
	public void testCheckValidity1() {
		token.x1 = 9;
		token.y1 = 2;
		assertFalse("Should be false!", token.checkValidity1());
		
		token.x1 = 2;
		token.y1 = 9;
		assertFalse("Should be false!", token.checkValidity1());
		
		token.x1 = 1;
		token.y1 = 2;
		assertTrue("Should be true!", token.checkValidity1());
		
		token.x1 = 2;
		token.y1 = 2;
		assertFalse("Should be false!", token.checkValidity1());
	}
	
	@Test
	public void testPossiblePositions() {
		token.x1 = 1;
		token.y1 = 2;
		
		token.possiblePositions();
		
		assertEquals(0, token.xp1);
		assertEquals(3, token.yp1);
		assertEquals(2, token.xp2);
		assertEquals(3, token.yp2);
	}
	
	@Test
	public void testCheckOccupation() {
		assertFalse("Should be false!", token.checkOccupation(2, 1));
		assertFalse("Should be false!", token.checkOccupation(5, 0));
		assertTrue("Should be true!", token.checkOccupation(3, 2));
	}
	
	@Test
	public void testEnterNewCoordinates() {
		token.x2 = 1;
		token.y2 = 2;
		assertEquals(1, token.x2);
		assertEquals(2, token.y2);
	}
	
	@Test
	public void testCheckValidity2() {
		token.x2 = 9;
		token.y2 = 2;
		assertFalse("Should be false!", token.checkValidity2());
		
		token.x2 = 2;
		token.y2 = 9;
		assertFalse("Should be false!", token.checkValidity2());
	}
	
	@Test
	public void testCheckValidity2_2() {
		token.x1 = 1;
		token.y1 = 2;
		token.possiblePositions();
		
		token.x2 = 0;
		token.y2 = 3;
		
		assertTrue("Should be true!", token.checkValidity2());
		
		token.x2 = 2;
		token.y2 = 3;
		
		assertTrue("Should be true!", token.checkValidity2());
	}
	
	@Test
	public void testCheckValidity2_3() {
		token.x1 = 1;
		token.y1 = 2;
		token.possiblePositions();
		
		token.x2 = 0;
		token.y2 = 4;
		
		assertFalse("Should be false!", token.checkValidity2());
	}
	
}
