package co.ardicarl.gatewayserver.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder
			.inMemoryAuthentication()
				.withUser("user").password("{noop}password").roles("USER")
			.and()
				.withUser("admin").password("{noop}admin").roles("ADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
			.authorizeRequests()
				.antMatchers("/book-api/books").permitAll()
				.antMatchers("/eureka/**").hasRole("ADMIN")
			.anyRequest().authenticated()
				.and()
					.formLogin()
				.and()
					.logout().permitAll()
			.and()
				.csrf().disable();
	}
}
