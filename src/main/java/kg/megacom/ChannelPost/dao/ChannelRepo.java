package kg.megacom.ChannelPost.dao;

import kg.megacom.ChannelPost.models.entities.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChannelRepo extends JpaRepository<Channel, Long> {

    @Query(value = "SELECT DISTINCT * FROM channels WHERE order_num = (SELECT max(order_num) FROM channels)", nativeQuery = true)
    Channel findLastChannelInTheList();
}
