/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.ciclo3.ciclo3;

import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author roll-
 */
@RestController
public class SecurityController extends WebSecurityConfigurerAdapter {
    
    
    @Override
        protected void configure(HttpSecurity http)throws Exception{
        
        /*
            http.antMatcher("/**").authorizeRequests()
                    .antMatchers(new String[]{"/","/sin-restriccion"}).permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .cauth2Login;
                    http.cors().and().csrf().disable();
            
            
         */   
            
            
            
           http.authorizeRequests(a->a
                
                .antMatchers("/**","/url/**","/webjars/**","/Reservation/**",
                        "/Client/**","/Doctor","/Especialty/**",
                        "/Message/**","/Score/**"
                ).permitAll()
                .anyRequest().authenticated()
             
            ).exceptionHandling(e->e
            
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                    
            ).oauth2Login();
            http.cors().and().csrf().disable();
        
        
        }
    
    
}
