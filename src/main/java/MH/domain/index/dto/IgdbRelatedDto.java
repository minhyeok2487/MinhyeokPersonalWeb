package MH.domain.index.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class IgdbRelatedDto {
	private int Id;

	private String Name;

	private String Url;

	private String Related_Content;

}
