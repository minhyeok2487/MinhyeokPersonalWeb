package MH.domain.lostark.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LostarkCharacterProfileDto {
	private String characterName;

	private String characterImage;

	private String characterClassName;

	private double itemMaxLevel;

	// 카오스 던전 이름
	private String chaosName;

	// 가디언 토벌 이름
	private String guardianName;

	public void setItemMaxLevel(Object object) {
		String level = object.toString();
		level = level.replaceAll(",","");
		this.itemMaxLevel = Double.parseDouble(level);
	}
}
