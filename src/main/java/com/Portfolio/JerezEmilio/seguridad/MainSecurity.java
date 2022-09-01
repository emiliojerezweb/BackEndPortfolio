
package com.Portfolio.JerezEmilio.seguridad;

import com.Portfolio.JerezEmilio.seguridad.jwt.JwtEntryPoint;
import com.Portfolio.JerezEmilio.seguridad.jwt.JwtTokenFilter;
import com.Portfolio.JerezEmilio.seguridad.servicio.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/*
    Los metodos que no llevan anotacion el admin ingresa como usuario generico
    @preauthorized solo accede el admin
*/
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MainSecurity extends WebSecurityConfigurerAdapter {
    
    @Autowired
    UserDetailsServiceImpl userDetailsService;
    
    @Autowired
    JwtEntryPoint jwtEntryPoint;
    
    @Bean
    public JwtTokenFilter jwtTokenFilter(){
        return new JwtTokenFilter();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    
    
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    } 
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //Se desactiva cookies porque se envia token
        http.cors().and().csrf().disable()
        .authorizeRequests().antMatchers("/auth/**").permitAll()
        .anyRequest().authenticated().and().exceptionHandling()
        .authenticationEntryPoint(jwtEntryPoint).and()
        .exceptionHandling().authenticationEntryPoint(jwtEntryPoint)
        .and().sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        
        http.addFilterBefore(jwtTokenFilter(), 
                            UsernamePasswordAuthenticationFilter.class);
    }
}
