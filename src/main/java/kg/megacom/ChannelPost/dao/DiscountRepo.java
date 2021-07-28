package kg.megacom.ChannelPost.dao;

import kg.megacom.ChannelPost.models.entities.Discount;
import kg.megacom.ChannelPost.models.entities.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscountRepo extends JpaRepository<Discount, Long> {
    List<Discount> findByChannelId(Long channelId);
    @Query(value = "SELECT * FROM discounts ds WHERE ds.id_channels = ?1 AND CURRENT_TIMESTAMP BETWEEN start_date AND end_date order by min_day asc", nativeQuery = true)
    List<Discount> allCurrentlyActiveDiscounts(Long id);
}
