package MH.domain.lostark.entity.lostarkContentAvg;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LostarkContentAvg {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	//분류
	private String category;

	//컨텐츠 이름
	private String name;

	//아이템 레벨
	private int level;

	//실링
	private double shilling;

	//명파
	private double honorShard;

	//돌파석
	private double leapStone;

	//파괴석
	private double destructionStone;

	//수호석
	private double guardianStone;

	//1렙 보석
	private double jewelry;

	//골드방, 보스방 골드 평균
	private double gold;

}
