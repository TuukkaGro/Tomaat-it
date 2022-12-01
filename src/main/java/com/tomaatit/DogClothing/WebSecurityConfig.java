package com.tomaatit.DogClothing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.tomaatit.DogClothing.web.UserDetailServiceImpl;


@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
    		.authorizeRequests()
    			//allow access to these endpoints without authentication
    		  .antMatchers("/", "/home").permitAll()
	    	  .anyRequest().authenticated()
	    	  .and()
	    	.formLogin()
	    	  .loginPage("/login") //endpoint for login page
	    	  .defaultSuccessUrl("/home", true) //redirects to indexpage after login
	    	  .permitAll()
	    	  .and()
	    	.logout()
	    	  .permitAll();
    }


    @Autowired
    private UserDetailServiceImpl userDetailsService;
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

}
