package tickets.dto.request;

import javax.validation.constraints.Size;
import lombok.Data;
import lombok.ToString;
import tickets.lib.FieldsValueMatch;
import tickets.lib.ValidEmail;

@FieldsValueMatch(
        field = "password",
        fieldMatch = "repeatPassword",
        message = "Password and confirmation password do not match."
)
@Data
public class UserRequestDto {
    @ValidEmail
    private String email;
    @Size(min = 6, max = 40)
    @ToString.Exclude
    private String password;
    @ToString.Exclude
    private String repeatPassword;
}
