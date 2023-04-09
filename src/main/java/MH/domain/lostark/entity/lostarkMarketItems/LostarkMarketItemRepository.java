package MH.domain.lostark.entity.lostarkMarketItems;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LostarkMarketItemRepository extends JpaRepository<LostarkMarketItem,Integer> {

	LostarkMarketItem findByName(String name);
}
