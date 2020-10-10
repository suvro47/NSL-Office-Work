package security.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.inMemoryAuthentication()
	                .withUser("suvro")
	                .password("1234")
	                .roles("USER")
	                .and()
	                .withUser("tanvir")
	                .password("1234")
	                .roles("ADMIN");
	    }
	    
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	                .csrf().disable()
	                .authorizeRequests()
	                .antMatchers("/user").hasRole("USER")
	                .antMatchers("/admin").hasRole("ADMIN")
	                .antMatchers("/").permitAll()
	                .anyRequest()
	                .authenticated()
	                .and()
	                .formLogin();
	    }
	    
	    @Bean
		public PasswordEncoder getPasswordEncoder() { return NoOpPasswordEncoder.getInstance(); }



}
