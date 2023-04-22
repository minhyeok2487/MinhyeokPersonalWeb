package MH.domain.lostark.entity.lostarkContentAvg;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LostarkContentRepository extends JpaRepository<LostarkContentAvg,Integer> {
    List<LostarkContentAvg> findAllByCategoryOrderByLevelAsc(String category);
}
