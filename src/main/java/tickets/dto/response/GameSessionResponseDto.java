package tickets.dto.response;

import lombok.Data;

@Data
public class GameSessionResponseDto {
    private Long gameSessionId;
    private Long gameId;
    private String gameTitle;
    private Long stadiumId;
    private String showTime;
}
