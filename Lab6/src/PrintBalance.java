import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * TODO A simple class that needs to be localized
 * 
 * @author mohan. Created Mar 27, 2010.
 */
public class PrintBalance {

	/**
	 * Simple Java Method that is crying out to be localized.
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		
		Locale aLocale = new Locale("en", "US");
		Locale caLocale = new Locale("fr", "CA");
		Locale frLocale = new Locale("fr", "FR");
		Locale deLocale = new Locale("de", "DE");
		
		Locale.setDefault(aLocale);
		
		ResourceBundle messages;
		messages = ResourceBundle.getBundle("MessagesBundle", Locale.getDefault());

		Scanner scanInput = new Scanner(System.in);
		Date today = new Date();

		// Greeting
		System.out.println(messages.getString("Greeting"));

		// Get User's Name
		System.out.println(messages.getString("Request"));
		String name = scanInput.nextLine();
		System.out.println(messages.getString("Meeting") + name);

		// print today's date, balance and bid goodbye
		System.out.println(messages.getString("AsOf") +
				DateFormat.getDateTimeInstance().format(today));
		
		char money;
		String country = Locale.getDefault().getCountry();
		if (country == "US" || country == "CA") {
			money = '$';
//		} else if (country == "UK"){
//			money = 0;
//			//money = '\pound';
		} else {
			money = '\u20ac';
		}
		System.out.println(messages.getString("Debt" + money +
				NumberFormat.getCurrencyInstance().format(9876543.21)));
		System.out.println(messages.getString("Farewell"));
	}
}