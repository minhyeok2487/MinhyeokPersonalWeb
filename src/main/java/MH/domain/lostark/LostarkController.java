package MH.domain.lostark;

import MH.domain.lostark.dto.LostarkCharacterProfileDto;
import MH.domain.lostark.dto.LostarkContentAvgDto;
import MH.domain.lostark.entity.lostarkMarketItems.LostarkMarketItem;
import MH.domain.lostark.service.LostarkCharacterApiService;
import MH.domain.lostark.service.LostarkContentAvgService;
import MH.domain.lostark.service.LostarkMarketItemService;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class LostarkController {

    private final LostarkMarketItemService marketItemService;
    private final LostarkContentAvgService contentAvgService;
    private final LostarkCharacterApiService characterApiService;

    @GetMapping("/lostark")
    public String index(Model model) {
        List<LostarkMarketItem> marketItems = marketItemService.getMarketItems();
        List<LostarkContentAvgDto> contentAvg = contentAvgService.contentAvg();
        List<LostarkContentAvgDto> contentAvgTotal = contentAvgService.contentAvgTotal(contentAvg);
        model.addAttribute("marketItems", marketItems);
        model.addAttribute("contentAvg", contentAvg);
        model.addAttribute("contentAvgTotal", contentAvgTotal);
        return "lostark/lostarkIndex";
    }

    @GetMapping("/lostark/character")
    public String character(Model model) {
        String mainCharacter = "마볼링";
        JSONArray character = characterApiService.Characters(mainCharacter);
        String mainServer = "루페온";
        ArrayList characters = new ArrayList();
        for (Object object : character) {
            JSONObject jsonObject = (JSONObject) object;
            if (jsonObject.get("ServerName").equals(mainServer)) {
                JSONObject characterName = characterApiService.characterProfiles((String) jsonObject.get("CharacterName"));
                LostarkCharacterProfileDto dto = new LostarkCharacterProfileDto();
                dto.setCharacterName((String) jsonObject.get("CharacterName"));
                dto.setCharacterImage((String) characterName.get("CharacterImage"));
                dto.setCharacterClassName((String) characterName.get("CharacterClassName"));
                dto.setItemMaxLevel(characterName.get("ItemMaxLevel"));
                dto = setContent(dto);
                characters.add(dto);
            }
        }

        // dto안에 ItemMaxLevel순으로 정렬
        Comparator<LostarkCharacterProfileDto> itemMaxLevelComparator = Comparator.comparingDouble(dto -> dto.getItemMaxLevel());
        characters.sort(itemMaxLevelComparator.reversed());
        model.addAttribute("characters", characters);
        model.addAttribute("mainCharacter", mainCharacter);
        model.addAttribute("mainServer", mainServer);
        return "lostark/lostarkCharacter";
    }

    private LostarkCharacterProfileDto setContent(LostarkCharacterProfileDto dto) {
        double level = dto.getItemMaxLevel();
        if (level < 1415) {
            dto.setChaosName("X");
            dto.setGuardianName("X");
        } else if (level >= 1415 && level < 1445) {
            dto.setChaosName("타락 1");
            dto.setGuardianName("데스칼루다");
        } else if (level >= 1445 && level < 1460) {
            dto.setChaosName("타락 2");
            dto.setGuardianName("데스칼루다");
        } else if (level >= 1460 && level < 1475) {
            dto.setChaosName("타락 2");
            dto.setGuardianName("쿤겔라니움");
        } else if (level >= 1475 && level < 1490) {
            dto.setChaosName("타락 3");
            dto.setGuardianName("쿤겔라니움");
        } else if (level >= 1490 && level < 1520) {
            dto.setChaosName("공허 1");
            dto.setGuardianName("칼엘리고스");
        } else if (level >= 1520 && level < 1540) {
            dto.setChaosName("공허 2");
            dto.setGuardianName("칼엘리고스");
        } else if (level >= 1540 && level < 1560) {
            dto.setChaosName("절망 1");
            dto.setGuardianName("하누마탄");
        } else if (level >= 1560 && level < 1580) {
            dto.setChaosName("절망 2");
            dto.setGuardianName("하누마탄");
        } else if (level >= 1580 && level < 1600) {
            dto.setChaosName("천공 1");
            dto.setGuardianName("소나벨");
        } else if (level >= 1600 && level < 1610) {
            dto.setChaosName("천공 2");
            dto.setGuardianName("소나벨");
        } else if (level >= 1610) {
            dto.setChaosName("계몽 1");
            dto.setGuardianName("가르가디스");
        }
        return dto;
    }
}
