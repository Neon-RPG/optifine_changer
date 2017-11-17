package su.fudo.neon.application.Threads;

import su.fudo.neon.application.Main;
import su.fudo.neon.application.console.console;
import su.fudo.neon.application.fs.unzip;
import su.fudo.neon.application.xml.LANG;

import static su.fudo.neon.application.console.console.Log;

public class UnZip {
	static Thread thread = new Thread(){
		public void run(){
			Log(LANG.$("UnZip.start")+"...");
			boolean x = unzip.$(Download.TempZip, Download.VersionFolder);
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
	;static void callBack(boolean l){
		if(l){
			Log(LANG.$("UnZip.success")+"!");
			Main.end();
		}else{
			Log(LANG.$("UnZip.failed")+Download.TempZip+" ...");
			console.close();
		}

	}
}
