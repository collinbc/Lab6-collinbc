import static org.junit.Assert.*;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

public class PrintBalanceTest {
	public String getMessage(Locale loc, String key){
		return ResourceBundle.getBundle("MessagesBundle", loc).getString(key);
	}
	
	@Test
	public void testEnglish() {
		assertEquals(getMessage(new Locale("en", "US"), "Greeting"), "Hello World");
	}
	
	@Test
	public void testGerman() {
		assertEquals(getMessage(new Locale("de", "DE"), "Farewell"), "Aufwiedersehen");
	}
	
	@Test
	public void testFrench() {
		assertEquals(getMessage(new Locale("fr", "FR"), "Debt"), "Vous devez l'école ");
		assertEquals(getMessage(new Locale("fr", "FR"), "AsOf"), getMessage(new Locale("fr", "CA"), "AsOf"));
	}
	
	@Test
	public void testNumberFormat() {
		assertEquals(NumberFormat.getCurrencyInstance().format(9876543.21), "$9,876,543.21");
	}
}
