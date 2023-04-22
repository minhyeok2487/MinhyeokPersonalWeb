package MH.domain.lostark.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LostarkContentAvgDto {
	private int level;

	private String name;

	private String category;

	private double availablePrice;

}
