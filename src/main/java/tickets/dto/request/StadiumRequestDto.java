package tickets.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class StadiumRequestDto {
    @Min(100)
    private int capacity;
    @Size(max = 500)
    private String description;
}
