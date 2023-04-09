package MH.domain.restaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDto {

	int id;
	String Name;
	String Category;
	String Menu;
	String Review;
	String Takeout;
	String x;
	String y;
	String KakaoUrl;
	String NaverUrl;
}
