package kg.megacom.ChannelPost.dao;

import kg.megacom.ChannelPost.models.entities.Day;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DayRepo extends JpaRepository<Day, Long> {
}
