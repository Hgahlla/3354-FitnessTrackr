

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import static org.junit.Assert.*;

public class SignUpTest {
	SignUp test = new SignUp();
	boolean result;

	@Test
	public void testExist() throws FileNotFoundException {
		result = test.exist("huynguyen1293@gmail.com");
		assertEquals(true,result);
		}
	
	@Test
	public void testIsValidPW() throws FileNotFoundException {
		result = test.isValidPW("sd@eqwe");
		assertEquals(false,result);
		result = test.isValidPW("TeStInG123");
		assertEquals(true,result);
	}
	
	@Test
	public void testIsValidFormat() throws FileNotFoundException {
		result = test.isValidFormat("02/07/1989");
		assertEquals(true,result);
		result = test.isValidFormat("04192019");
		assertEquals(false,result);
	}

	@Test
	public void testIsNumber() throws FileNotFoundException {
		result = test.isNumber("02/07/1989");
		assertEquals(false,result);
		result = test.isNumber("04192019");
		assertEquals(true,result);
	}
	
	@Test
	public void testIsValidName() throws FileNotFoundException {
		result = test.isValidName("Smith");
		assertEquals(true,result);
		result = test.isValidName("R2D2");
		assertEquals(false,result);
	}
	
	@Test
	public void testWriteInfoToDB() throws IOException {
		String result = test.WriteInfoToDB("johnsmith@yahoo.com John Smith simplepassword12 72 180 male 01/01/1990");
		assertEquals(result,test.WriteInfoToDB("johnsmith@yahoo.com John Smith simplepassword12 72 180 male 01/01/1990"));
	}
	
}
