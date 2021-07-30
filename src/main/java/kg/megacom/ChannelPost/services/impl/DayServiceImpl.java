package kg.megacom.ChannelPost.services.impl;

import kg.megacom.ChannelPost.dao.DayRepo;
import kg.megacom.ChannelPost.mappers.DayMapper;
import kg.megacom.ChannelPost.models.dtos.DayDto;
import kg.megacom.ChannelPost.models.dtos.OrderDetailDto;
import kg.megacom.ChannelPost.services.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DayServiceImpl implements DayService {
    @Autowired
    private DayRepo dayRepo;
    @Autowired
    private DayMapper dayMapper;
    @Override
    public DayDto save(DayDto dayDto) {
        return dayMapper.toDto(dayRepo.save(dayMapper.toEntity(dayDto)));
    }

    @Override
    public void saveByDateAndOrderDetailDto(Date date, OrderDetailDto orderDetailDto) {
        DayDto dayDto = new DayDto();
        dayDto.setDay(date);
        dayDto.setOrderDetailDto(orderDetailDto);
        dayRepo.save(dayMapper.toEntity(dayDto));
    }

    @Override
    public List<DayDto> findByOrderDetailId(Long id) {
        return dayMapper.toDtos(dayRepo.findByOrderDetailId(id));
    }
}
