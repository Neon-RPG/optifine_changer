package su.fudo.neon.application.console;

import java.util.Scanner;

import static su.fudo.neon.application.console.console.Log;

public class Choice {
	public static Scanner scan=new Scanner(System.in);
	public static String scanned;
	public static Runnable callback;
	public static void waitChoice(String enter, Runnable test, Runnable callbackf) {
		Log(enter);
		callback = callbackf;
		scanned = scan.next();
		/*switch (type){
			case "String":

				break;
			case "boolean":
				break;
			case "int":
				break;
		}*/
		test.run();
		//callback.run();
	}


}
