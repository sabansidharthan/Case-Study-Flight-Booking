package com.apigateway.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.apigateway.jwtfilter.JWTFilter;
import com.apigateway.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JWTFilter jwtFilter;
	
////for in-memory user id and pass word////
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		System.out.println("authenticated");

		auth.userDetailsService(userService);
//		auth.inMemoryAuthentication()
//				.withUser("admin").password("admin").roles("admin").and()
//				.withUser("user").password("user").roles("user");

	}

	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable()
				.authorizeRequests()
				.antMatchers("/authenticate")
				.permitAll()
				.antMatchers("/user/addUser")
				.permitAll()
				.antMatchers("/user/getUserByEmail/**")
				.permitAll()
				.antMatchers("/flight/searchFlights")
				.permitAll()
				.antMatchers("/booking/bookings")
				.permitAll()
				.antMatchers("/bookings/**")
				.permitAll()
				.antMatchers("/booking/booking/**")
				.permitAll()
				.antMatchers("/flight/addFlight")
				.permitAll()
				.anyRequest().authenticated()
				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
       }

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
