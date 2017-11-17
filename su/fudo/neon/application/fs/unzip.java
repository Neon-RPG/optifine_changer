package su.fudo.neon.application.fs;

import su.fudo.neon.application.xml.LANG;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static su.fudo.neon.application.console.console.Log;

public class unzip
{
	List<String> fileList;

	public static boolean $( String INPUT_ZIP_FILE, String OUTPUT_FOLDER )
	{
		unzip unZip = new unzip();
		return unZip.unZipIt(INPUT_ZIP_FILE,OUTPUT_FOLDER);
	}

	public boolean unZipIt(String zipFile, String outputFolder){
		byte[] buffer = new byte[1024];
		try{
			File folder = new File(outputFolder);
			if(!folder.exists()){
				folder.mkdir();
			}
			ZipInputStream zis =
					new ZipInputStream(new FileInputStream(zipFile));
			ZipEntry ze = zis.getNextEntry();
			while(ze!=null){
				String fileName = ze.getName();
				File newFile = new File(outputFolder + File.separator + fileName);
				Log(LANG.$("UnZip.proccess")+ newFile.getAbsoluteFile());
				new File(newFile.getParent()).mkdirs();
				FileOutputStream fos = new FileOutputStream(newFile);
				int len;
				while ((len = zis.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}
				fos.close();
				ze = zis.getNextEntry();
			}
			zis.closeEntry();
			zis.close();
			return true;
		}catch(IOException ex){
			ex.printStackTrace();
			return false;
		}
	}
}
