package tickets.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class GameRequestDto {
    @NotNull
    private String gameTitle;
    @Size(min = 1, max = 500)
    private String gameDescription;
}
