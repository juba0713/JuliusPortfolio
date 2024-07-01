package portfolio.controllers.function.customvalidation;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/function")
public class CustomValidationController {

	@GetMapping("/custom-validation")
	public String getPage(@ModelAttribute InputWebDto webDto) {
		
		return "custom-validation";
	}
	
	@PostMapping("/custom-validation")
	public RedirectView  postPage(@ModelAttribute @Valid InputWebDto webDto,
			BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			System.out.println("ERROR");
			return new RedirectView("/function/custom-validation", true);
		}
		
		System.out.println(webDto.getPassword());
		
		return new RedirectView("/function/custom-validation", false);
	}
}
