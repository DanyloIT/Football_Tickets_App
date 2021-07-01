package tickets.dto.response;

import lombok.Data;

@Data
public class GameResponseDto {
    private Long gameId;
    private String gameTitle;
    private String gameDescription;
}
