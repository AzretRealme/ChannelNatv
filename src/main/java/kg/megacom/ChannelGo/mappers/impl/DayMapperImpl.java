package kg.megacom.ChannelGo.mappers.impl;

import kg.megacom.ChannelGo.mappers.DayMapper;
import kg.megacom.ChannelGo.mappers.OrderDetailMapper;
import kg.megacom.ChannelGo.models.dtos.DayDto;
import kg.megacom.ChannelGo.models.entities.Day;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DayMapperImpl implements DayMapper {
    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Override
    public Day toEntity(DayDto dayDto) {
        Day day = new Day();
        day.setDay(dayDto.getDay());
        day.setId(dayDto.getId());
        day.setOrderDetail(orderDetailMapper.toEntity(dayDto.getOrderDetailDto()));
        return day;
    }

    @Override
    public DayDto toDto(Day day) {
        DayDto dayDto = new DayDto();
        dayDto.setDay(day.getDay());
        dayDto.setId(day.getId());
        dayDto.setOrderDetailDto(orderDetailMapper.toDto(day.getOrderDetail()));
        return dayDto;
    }

    @Override
    public List<Day> toEntities(List<DayDto> dayDtoList) {

        return dayDtoList.stream().map(x->{
            Day day = new Day();
            day.setDay(x.getDay());
            day.setId(x.getId());
            day.setOrderDetail(orderDetailMapper.toEntity(x.getOrderDetailDto()));
            return day;
        }).collect(Collectors.toList());
    }

    @Override
    public List<DayDto> toDtos(List<Day> days) {

        return days.stream().map(x->{
            DayDto dayDto = new DayDto();
            dayDto.setDay(x.getDay());
            dayDto.setId(x.getId());
            dayDto.setOrderDetailDto(orderDetailMapper.toDto(x.getOrderDetail()));
            return dayDto;
        }).collect(Collectors.toList());
    }
}
