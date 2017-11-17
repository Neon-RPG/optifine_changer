package su.fudo.neon.application.console;

import su.fudo.neon.application.xml.LANG;

import java.io.IOException;
import java.util.Scanner;

public class console {
	public static Scanner scan=new Scanner(System.in);
	public static String PrintPrefix(){
		return "[ "+ LANG.$("prefix")+" ]";
	}
	public static void Log(String l){
		System.out.println(PrintPrefix()+" "+l);
	}
	public static boolean testReadKey(){
		return scan.hasNext();
	}
	public static void readKey(){
		scan.nextLine();
	}
	public static void toclose(){
		try {
			int read = System.in.read(new byte[2]);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void close(){
		Log(LANG.$("app.toclose"));
		toclose();
	}
}
