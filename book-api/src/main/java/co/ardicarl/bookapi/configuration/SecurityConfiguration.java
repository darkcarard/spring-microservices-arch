package co.ardicarl.bookapi.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	public void configureGlobal1(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.inMemoryAuthentication();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
			.httpBasic().disable()
			.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/books").permitAll()
				.antMatchers(HttpMethod.GET, "/books/*").permitAll()
				.antMatchers(HttpMethod.POST, "/books").hasRole("ADMIN")
				.antMatchers(HttpMethod.PATCH, "/books/*").hasRole("ADMIN")
				.antMatchers(HttpMethod.DELETE, "/books/*").hasRole("ADMIN")
				.anyRequest().authenticated()
			.and()
				.csrf().disable();
	}
}
