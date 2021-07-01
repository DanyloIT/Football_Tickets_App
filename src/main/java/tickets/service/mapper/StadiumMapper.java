package tickets.service.mapper;

import org.springframework.stereotype.Component;
import tickets.dto.request.StadiumRequestDto;
import tickets.dto.response.StadiumResponseDto;
import tickets.model.Stadium;

@Component
public class StadiumMapper implements RequestDtoMapper<StadiumRequestDto, Stadium>,
        ResponseDtoMapper<StadiumResponseDto, Stadium> {
    @Override
    public Stadium mapToModel(StadiumRequestDto dto) {
        Stadium stadium = new Stadium();
        stadium.setDescription(dto.getDescription());
        stadium.setCapacity(dto.getCapacity());
        return stadium;
    }

    @Override
    public StadiumResponseDto mapToDto(Stadium stadium) {
        StadiumResponseDto responseDto = new StadiumResponseDto();
        responseDto.setId(stadium.getId());
        responseDto.setDescription(stadium.getDescription());
        return responseDto;
    }
}
