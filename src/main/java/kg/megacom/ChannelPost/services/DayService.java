package kg.megacom.ChannelPost.services;

import kg.megacom.ChannelPost.models.dtos.DayDto;
import kg.megacom.ChannelPost.models.dtos.OrderDetailDto;
import kg.megacom.ChannelPost.models.entities.Day;

import java.util.Date;
import java.util.List;

public interface DayService {
    DayDto save(DayDto dayDto);

    public void saveByDateAndOrderDetailDto(Date date, OrderDetailDto orderDetailDto);

    List<DayDto> findByOrderDetailId(Long id);
}
