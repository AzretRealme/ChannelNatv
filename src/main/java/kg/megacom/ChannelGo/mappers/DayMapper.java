package kg.megacom.ChannelGo.mappers;

import kg.megacom.ChannelGo.models.dtos.DayDto;
import kg.megacom.ChannelGo.models.entities.Day;

import java.util.List;

public interface DayMapper {
    Day toEntity(DayDto dayDto);
    DayDto toDto(Day day);


    List<Day> toEntities(List<DayDto> dayDtoList);
    List<DayDto> toDtos(List<Day> days);
}
