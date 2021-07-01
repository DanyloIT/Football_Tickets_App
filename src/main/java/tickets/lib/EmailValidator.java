package tickets.lib;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<ValidEmail, String> {
    public static final String VALID_EMAIL_REGEX = "^(.+)@(.+)$";

    @Override
    public boolean isValid(String field, ConstraintValidatorContext context) {
        return field != null && field.matches(VALID_EMAIL_REGEX);
    }
}
