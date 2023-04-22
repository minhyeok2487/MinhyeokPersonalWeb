package MH.domain.index;

import MH.dto.CMRespDto;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.ArrayList;

@Controller
@RequiredArgsConstructor
public class IGDBApiController {

	private final IGDBService igdbService;

	@PostMapping("/api/games/{igdbId}")
	public ResponseEntity<?> getItem(@PathVariable String igdbId) {
		ArrayList Game = igdbService.getGameItem(igdbId);
		return new ResponseEntity<>(new CMRespDto<>(1, "성공", Game), HttpStatus.OK);
	}

}
