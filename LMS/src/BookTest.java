import static org.junit.Assert.*;

import org.junit.Test;

public class BookTest {

	@Test
	public void testBook() {
		Book test = new Book();
			String result = test.Book("");
				assertEquals("a",result);
	}

}
