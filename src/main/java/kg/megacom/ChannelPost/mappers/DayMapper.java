package kg.megacom.ChannelPost.mappers;

import kg.megacom.ChannelPost.models.dtos.ChannelDto;
import kg.megacom.ChannelPost.models.dtos.DayDto;
import kg.megacom.ChannelPost.models.entities.Channel;
import kg.megacom.ChannelPost.models.entities.Day;

import java.util.List;

public interface DayMapper {
    Day toEntity(DayDto dayDto);
    DayDto toDto(Day day);


    List<Day> toEntities(List<DayDto> dayDtoList);
    List<DayDto> toDtos(List<Day> days);
}
