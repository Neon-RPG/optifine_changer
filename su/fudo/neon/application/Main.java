package su.fudo.neon.application;
//package su.fudo.neon.application.network;

import su.fudo.neon.application.Threads.testConnection;
import su.fudo.neon.application.xml.LANG;

import static su.fudo.neon.application.console.console.Log;
import static su.fudo.neon.application.console.console.close;

public class Main {


    public static void main(String[] args) {
		LANG.start();
		Log(LANG.$("app.start")+"...");
		testConnection.run();
	}
	public static void end(){
		Log(LANG.$("app.end")+"...");
    	close();
	}
}
