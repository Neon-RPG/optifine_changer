package su.fudo.neon.application.Threads;

import su.fudo.neon.application.console.Choice;
import su.fudo.neon.application.network.worker;
import su.fudo.neon.application.xml.LANG;

import static su.fudo.neon.application.console.Choice.scanned;
import static su.fudo.neon.application.console.console.Log;
import static su.fudo.neon.application.console.console.close;

//import static su.fudo.neon.application.console.Choice;

public class testConnection {
	static Thread thread = new Thread(){
		public void run(){
			Log(LANG.$("net.pinging")+"...");
			boolean x = worker.pingURL("https://n.fudo.su/pingTest.php", 1000);
			if(x){
				callBack(true);
			}else{
				callBack(false);
			}
		}
	};

	public static void run(){
		thread.run();
	}

	static void callBack(boolean t){
		if(t){
			Log(LANG.$("net.connection.sus")+"!");
			Choice.waitChoice(LANG.$("optifine.question"), new Runnable() {
				@Override
				public void run() {
					if(scanned.equalsIgnoreCase("y")){
						Log(LANG.$("thread.run")+"...");
						Choice.callback.run();
					}
					if(scanned.equalsIgnoreCase("n")){
						Log(LANG.$("optifine.no"));
						close();
					}
				}
			}, new Runnable() {
				@Override
				public void run() {
					//Log(String.valueOf(Download.$("https://n.fudo.su/optifine/actual.zip",System.getenv("APPDATA")+"\\.minecraft\\versions\\neon_optifine-temp.zip" )));
					Download.run();
				}
			});
		}else{
			Log(LANG.$("net.connection.fail")+"...");
			close();
		}

		//close();
	}
}
