package portfolio.controllers.function.customvalidation;

import lombok.Data;
import portfolio.annotations.NotEmpty;
import portfolio.annotations.PasswordMatch;

@Data
@PasswordMatch
public class InputWebDto {

	@NotEmpty
	public String password;
	
	@NotEmpty
	public String confirmPassword;	
}
