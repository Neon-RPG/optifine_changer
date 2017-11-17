package su.fudo.neon.application.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class LANG {
	public static String app_start;
	public static String app_end;
	public static String app_toclose;
	public static String net_connection_sus;
	public static String net_connection_fail;
	public static String net_pinging;
	public static String net_startdownload;
	public static String net_faileddownload;
	public static String net_successdownload;
	public static String optifine_question;
	public static String optifine_no;
	public static String thread_run;
	public static String UnZip_start;
	public static String UnZip_success;
	public static String UnZip_failed;
	public static String UnZip_proccess;

	public static HashMap<String, String> a = new HashMap<String, String>();

	public static String DefaultFile = "<?xml version=\"1.0\"?>\n" +
			"<su.fudo.neon.application>\n" +
			"\t<lang>\n" +
			"\t\t<l type=\"prefix\" data=\"Neon-RPG\" />\n" +
			"\t\t<l type=\"app.start\" data=\"Application start\" />\n" +
			"\t\t<l type=\"app.end\" data=\"All proccess'es end'ed successful! Thank for playning from Neon-RPG!\" />\n" +
			"\t\t<l type=\"app.toclose\" data=\"Press ENTER - to close\" />\n" +
			"\t\t<l type=\"net.connection.sus\" data=\"Connection successful\" />\n" +
			"\t\t<l type=\"net.connection.fail\" data=\"Connection failed\" />\n" +
			"\t\t<l type=\"net.pinging\" data=\"Pinging neon-server's\" />\n" +
			"\t\t<l type=\"net.startdownload\" data=\"Actual version downloading\" />\n" +
			"\t\t<l type=\"net.faileddownload\" data=\"Loading failed! Please restart application\" />\n" +
			"\t\t<l type=\"net.successdownload\" data=\"Loading successful\" />\n" +
			"\t\t<l type=\"optifine.question\" data=\"Update/install Neon-RPG Optifine?  (Y/N) :\" />\n" +
			"\t\t<l type=\"optifine.no\" data=\"Oh ok! Good Bye ^_^\" />\n" +
			"\t\t<l type=\"thread.run\" data=\"Wait a moment\" />\n" +
			"\t\t<l type=\"UnZip.start\" data=\"Un-Zip'ing temp-archive\" />\n" +
			"\t\t<l type=\"UnZip.success\" data=\"Archive Un-Zip'ed successful\" />\n" +
			"\t\t<l type=\"UnZip.failed\" data=\"Un-Zip'ing failed! Check : \" />\n" +
			"\t\t<l type=\"UnZip.proccess\" data=\"file unzip : \" />\n" +
			"\t</lang>\n" +
			"</su.fudo.neon.application>";

	public static void start() {
		File fXmlFile = new File("lang.xml");

		if(!fXmlFile.exists()){
			BufferedWriter output = null;
			try {
				output = new BufferedWriter(new FileWriter(fXmlFile));
				output.write(DefaultFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("l");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					a.put(eElement.getAttribute("type"), eElement.getAttribute("data"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static String $(String t){
		return LANG.a.get(t);
	}
}
