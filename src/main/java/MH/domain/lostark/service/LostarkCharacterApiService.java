package MH.domain.lostark.service;

import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

@Service
@RequiredArgsConstructor
public class LostarkCharacterApiService {
	@Value("${Lostark-API-Key}")
	private String LostarkApiKey;

	public JSONArray Characters(String characterName) {
		try {
			characterName = URLEncoder.encode(characterName, "UTF-8");
			URL url = new URL("https://developer-lostark.game.onstove.com/characters/"+characterName+"/siblings");
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setRequestMethod("GET");
			httpURLConnection.setRequestProperty("authorization", "Bearer "+ LostarkApiKey);
			httpURLConnection.setRequestProperty("accept","application/json");
			httpURLConnection.setRequestProperty("content-Type","application/json");
			httpURLConnection.setDoOutput(true);

			int result = httpURLConnection.getResponseCode();
			InputStream inputStream;
			if(result == 200) {
				inputStream = httpURLConnection.getInputStream();
			} else {
				inputStream = httpURLConnection.getErrorStream();
			}
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

			JSONParser parser = new JSONParser();
			JSONArray array = (JSONArray) parser.parse(inputStreamReader);
			return array;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public JSONObject characterProfiles(String characterName) {
		try {
			characterName = URLEncoder.encode(characterName, "UTF-8");
			URL url = new URL("https://developer-lostark.game.onstove.com/armories/characters/"+characterName+"/profiles");
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setRequestMethod("GET");
			httpURLConnection.setRequestProperty("authorization", "Bearer "+ LostarkApiKey);
			httpURLConnection.setRequestProperty("accept","application/json");
			httpURLConnection.setRequestProperty("content-Type","application/json");
			httpURLConnection.setDoOutput(true);

			int result = httpURLConnection.getResponseCode();
			InputStream inputStream;
			if(result == 200) {
				inputStream = httpURLConnection.getInputStream();
			} else {
				inputStream = httpURLConnection.getErrorStream();
			}
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

			JSONParser parser = new JSONParser();
			JSONObject object = (JSONObject) parser.parse(inputStreamReader);
			return object;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
