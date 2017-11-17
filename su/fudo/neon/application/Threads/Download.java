package su.fudo.neon.application.Threads;

import org.apache.commons.io.FileUtils;
import su.fudo.neon.application.xml.LANG;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static su.fudo.neon.application.console.console.Log;
import static su.fudo.neon.application.console.console.close;

public class Download {
	public static String TempZip = System.getenv("APPDATA")+"\\.minecraft\\versions\\neon_optifine-temp.zip";
	public static String VersionFolder = System.getenv("APPDATA")+"\\.minecraft\\versions\\1.12-OptiFine_HD_U_C5";
	public static String UrlActual = "https://n.fudo.su/optifine/actual.zip";
	static Thread thread = new Thread(){
		public void run(){
			Log(LANG.$("net.startdownload")+"...");
			boolean x = $(UrlActual, TempZip);
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
	public static boolean $(String fromFile, String toFile){
		try {
			FileUtils.copyURLToFile(new URL(fromFile), new File(toFile), 10000, 10000);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	static void callBack(boolean l){
		if(l){
			Log(LANG.$("net.successdownload")+"!");
			Path path = Paths.get(VersionFolder+"\\1");
			if (!Files.exists(path)) {
			try {
				Files.createDirectories(path);

			} catch (IOException e) {
				e.printStackTrace();
				close();
			}}
			UnZip.run();
			//UnZip.run();
		}else{
			Log(LANG.$("net.faileddownload")+"...");
			close();
		}

	}
}
