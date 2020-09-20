package com.dw3.app;



import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
       http.cors().and().csrf().disable().authorizeRequests()
        .antMatchers("/").permitAll()
        .antMatchers(HttpMethod.POST,"/addtask").permitAll()
        .antMatchers(HttpMethod.GET, "/getalltasks").permitAll()
        .antMatchers(HttpMethod.GET,"/taks/findbyid/*").permitAll()
        .antMatchers(HttpMethod.PUT,"/task/{id}").permitAll()
        .antMatchers(HttpMethod.DELETE,"/task/{id}").permitAll()
        .anyRequest().authenticated();
    }
    
 

}