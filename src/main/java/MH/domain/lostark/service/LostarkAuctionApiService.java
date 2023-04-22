package MH.domain.lostark.service;

import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class LostarkAuctionApiService {
	@Value("${Lostark-API-Key}")
	private String LostarkApiKey;

	public JSONObject AuctionItems(int CategoryCode, String ItemName) {
		try {
			URL url = new URL("https://developer-lostark.game.onstove.com/auctions/items");
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setRequestMethod("POST");
			httpURLConnection.setRequestProperty("authorization", "Bearer "+ LostarkApiKey);
			httpURLConnection.setRequestProperty("accept","application/json");
			httpURLConnection.setRequestProperty("content-Type","application/json");
			httpURLConnection.setDoOutput(true);

			String parameter = "{"
					+ "Sort : \"BUY_PRICE\""
					+ ",CategoryCode : " + CategoryCode
					+ ",ItemTier : 3"
					+ ",ItemName : \""+ ItemName +"\""
					+ ",PageNo : 1"
					+ ",SortCondition : \"ASC\""
					+ "}";
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
			JSONObject object = (JSONObject) parser.parse(inputStreamReader);

			return object;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
