package com.sprint.bspro.security;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.sprint.bspro.service.BookStoreServiceImpl;

@Configuration
@EnableWebSecurity
public class IBASecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	JWTAuthenticationFilter jwtAuthenticationFilter;

	@Autowired
	UserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println(" --->> configure HTTp method - start");
		http.
		// csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
		// .and().
				csrf().disable().cors().disable().authorizeRequests().

//				antMatchers("/swagger-ui.html", "/v2/api-docs", "/webjars/**", "/swagger-resources/**", "/v3/api-docs").permitAll()
//				antMatchers("/swagger-ui.html").permitAll()
				antMatchers("/user/**").permitAll()
				.antMatchers("/login/**").permitAll()
		.antMatchers("/author/**").permitAll()
				.antMatchers("/admin/**").permitAll()
//				.antMatchers("/account/**").hasAnyAuthority("ADMIN", "USER").

				.anyRequest().authenticated().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		// ----- configure JWTFilters for all next request
		http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
		System.out.println(" --->> configure HTTp method - End");
	} // end httpSecurity configuration

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		System.out.println("=============>> inside security Config class - method auth manager builder " + auth);
		auth.authenticationProvider(authenticationProvider());
		// auth.userDetailsService(null)

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		return new BookStoreServiceImpl();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {

		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		System.out.println("=============>> Inside Security Config class DAO auth provider " + authProvider);
		return authProvider;
	}

	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		System.out.println(" --->> Inside AuthenticationManager @Bean ");
		return super.authenticationManagerBean();
	}

}// end class