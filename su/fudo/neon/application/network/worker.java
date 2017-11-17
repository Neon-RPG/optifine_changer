package su.fudo.neon.application.network;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class worker {
	public static boolean pingURL(String url, int timeout) {
		url = url.replaceFirst("^https", "http");
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			connection.setConnectTimeout(timeout);
			connection.setReadTimeout(timeout);
			connection.setRequestMethod("HEAD");
			int responseCode = connection.getResponseCode();
			return (200 <= responseCode && responseCode <= 399);
		} catch (IOException exception) {
			return false;
		}
	}
}
