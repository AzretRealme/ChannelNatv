package kg.megacom.ChannelPost.dao;

import kg.megacom.ChannelPost.models.entities.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepo extends JpaRepository<OrderDetail, Long> {
    OrderDetail findDistinctByChannelId(Long id);

    List<OrderDetail> findByOrderId(Long id);
}
