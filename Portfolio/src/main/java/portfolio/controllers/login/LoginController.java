package portfolio.controllers.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class LoginController {

	@GetMapping("/{system}/login")
	public String showLogin(@PathVariable("system") String system) {
		
		switch(system) {
			case "AnswerEase":
				return "answerease/login";
			default:
				return "login";
		}
	}
}
