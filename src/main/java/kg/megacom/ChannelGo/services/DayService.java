package kg.megacom.ChannelGo.services;

import kg.megacom.ChannelGo.models.dtos.DayDto;
import kg.megacom.ChannelGo.models.dtos.OrderDetailDto;

import java.util.Date;
import java.util.List;

public interface DayService {
    DayDto save(DayDto dayDto);

    public void saveByDateAndOrderDetailDto(Date date, OrderDetailDto orderDetailDto);

    List<DayDto> findByOrderDetailId(Long id);
}
