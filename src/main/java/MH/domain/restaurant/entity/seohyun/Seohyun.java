package MH.domain.restaurant.entity.seohyun;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Seohyun {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
