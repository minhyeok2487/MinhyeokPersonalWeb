package MH.domain.restaurant.entity;

import java.util.List;

import MH.domain.restaurant.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

	List<Restaurant> findByXIsNotNullAndYIsNotNull();
}
