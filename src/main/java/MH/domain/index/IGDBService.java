package MH.domain.index;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

@Service
public class IGDBService {

	public JSONArray getGameItem(int igdbId) {
		try {
			URL url = new URL("https://api.igdb.com/v4/games");
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection(); // 서버 연결
			httpURLConnection.setRequestMethod("POST");
			httpURLConnection.setRequestProperty("Authorization", "Bearer 1djhjod5h91y2d6b7mms3gzgqt5vvv");
			httpURLConnection.setRequestProperty("Client-ID","um1wuuvmsfiqfm54gpyd8d5icgd1ve");
			httpURLConnection.setRequestProperty("Accept","application/json");
			httpURLConnection.setDoOutput(true);

			String parameter = "fields *; where id = "+igdbId+";";
			byte[] out = parameter.getBytes(StandardCharsets.UTF_8);

			OutputStream stream = httpURLConnection.getOutputStream();
			stream.write(out);

			int result = httpURLConnection.getResponseCode();

			InputStream inputStream;
			if(result == 200) {
				inputStream = httpURLConnection.getInputStream();
			} else {
				inputStream = httpURLConnection.getErrorStream();
			}
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			JSONParser parser = new JSONParser();
			JSONArray object = (JSONArray) parser.parse(inputStreamReader);

			return object;
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		} catch (IOException | ParseException e) {
			throw new RuntimeException(e);
		}
	}
}
