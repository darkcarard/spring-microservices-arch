package co.ardicarl.ratingapi.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal1(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.inMemoryAuthentication();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
			.httpBasic().disable()
			.authorizeRequests()
				.regexMatchers("^/ratings\\?bookId.*$").authenticated()
				.antMatchers(HttpMethod.POST, "/ratings").authenticated()
				.antMatchers(HttpMethod.PATCH, "/ratings/*").hasRole("ADMIN")
				.antMatchers(HttpMethod.DELETE, "/ratings/*").hasRole("ADMIN")
				.antMatchers(HttpMethod.GET, "/ratings").hasRole("ADMIN")
				.anyRequest().authenticated()
			.and().csrf()
				.disable();
	}
}
