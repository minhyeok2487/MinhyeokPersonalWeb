package MH.domain.lostark.entity.lostarkMarketItems;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LostarkMarketItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String grade;

	private String icon;

	private int bundleCount;

	private int tradeRemainCount;

	private double yDayAvgPrice;

	private int recentPrice;

	private int currentMinPrice;

}
