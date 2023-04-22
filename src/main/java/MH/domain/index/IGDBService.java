package MH.domain.index;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Service;

@Service
public class IGDBService {


	private String getBody(String html) {
		Pattern pattern = Pattern.compile("<body>(.*?)</body>", Pattern.DOTALL);
		Matcher matcher = pattern.matcher(html);
		if (matcher.find()) {
			return matcher.group(1);
		}
		return "";
	}


	public ArrayList getGameItem(String igdbIds) {
		String[] IdsArray = igdbIds.split("\\s+");
		ArrayList urls = new ArrayList<>();
		for (int i = 0; i < IdsArray.length; i++) {
			try {
				int igdbId = Integer.parseInt(IdsArray[i]);
				URL url = new URL("https://api.igdb.com/v4/games");
				HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection(); // 서버 연결
				httpURLConnection.setRequestMethod("POST");
				httpURLConnection.setRequestProperty("Authorization", "Bearer 1djhjod5h91y2d6b7mms3gzgqt5vvv");
				httpURLConnection.setRequestProperty("Client-ID", "um1wuuvmsfiqfm54gpyd8d5icgd1ve");
				httpURLConnection.setRequestProperty("Accept", "application/json");
				httpURLConnection.setDoOutput(true);

				String parameter = "fields name, url; where id = " + igdbId + ";";
				byte[] out = parameter.getBytes(StandardCharsets.UTF_8);

				OutputStream stream = httpURLConnection.getOutputStream();
				stream.write(out);

				int result = httpURLConnection.getResponseCode();

				InputStream inputStream;
				if (result == 200) {
					inputStream = httpURLConnection.getInputStream();
				} else {
					inputStream = httpURLConnection.getErrorStream();
				}
				InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
				JSONParser parser = new JSONParser();
				JSONArray object = (JSONArray) parser.parse(inputStreamReader);
				System.out.println(object);
				urls.add(object);
			} catch (MalformedURLException e) {
				throw new RuntimeException(e);
			} catch (IOException | ParseException e) {
				throw new RuntimeException(e);
			}
		}
		return urls;
	}
}
