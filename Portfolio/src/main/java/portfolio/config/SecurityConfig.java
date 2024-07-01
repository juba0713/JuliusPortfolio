package portfolio.config;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import portfolio.controllers.login.UserDetailsServiceImpl;


public class SecurityConfig {

	@Autowired
    private UserDetailsServiceImpl userDetailsService;
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // A strong password hashing algorithm
    }
	
	@Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
	
	@Bean
	protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/").permitAll()
				.requestMatchers("/login/**").permitAll()
				.requestMatchers("/css/**").permitAll()
				.requestMatchers("/js/**").permitAll()
				.requestMatchers("/favicon.ico").permitAll()
				.requestMatchers("/icons/**").permitAll()	
				.requestMatchers("/images/**").permitAll()
				.requestMatchers("/fonts/**").permitAll()
				.requestMatchers("/function/**").permitAll()
			)
			.formLogin((form) -> form
				.loginPage("/login")
				.loginProcessingUrl("/login")
				.permitAll()
				.failureUrl("/")
				.usernameParameter("username")
				.passwordParameter("password")
				.defaultSuccessUrl("/")
				//.successHandler(authenticationSuccessHandler())
			)
			.logout((logout) -> logout
					.logoutSuccessUrl("/")
					.invalidateHttpSession(true)
					.permitAll()
			);		
					
		return http.build();
	}
	
	@Bean
	public AuthenticationSuccessHandler authenticationSuccessHandler() {
	    return (request, response, authentication) -> {
	        // Get the user's roles
	        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

	        // Redirect based on roles (example)
	        for (GrantedAuthority authority : authorities) {
	            if (authority.getAuthority().equals("APPLICANT")) {
	                response.sendRedirect("/applicant/home");
	                return;
	            } else if (authority.getAuthority().equals("OFFICER")) {
	                response.sendRedirect("/officer/dashboard"); // Or whatever path is suitable
	                return;
	            } // ... other role checks
	        }

	        // Default redirect (if no specific role match)
	        response.sendRedirect("/"); 
	    };
	}
	
	
}
