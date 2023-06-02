package com.group.telegram_bot.config;

import com.group.telegram_bot.security.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletResponse;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http = http.csrf().disable();

        http = http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and();

        http = http
                .exceptionHandling()
                .authenticationEntryPoint(
                        (request, response, ex) -> response.sendError(
                                HttpServletResponse.SC_UNAUTHORIZED,
                                ex.getMessage()
                        )
                )
                .and();

        http
                .authorizeRequests()
                .antMatchers("/v2/api-docs/**").permitAll()
                .antMatchers("/swagger-ui/**").permitAll()
                .antMatchers("/favicon.ico").permitAll()
                .antMatchers("/swagger-resources/**").permitAll()
                .antMatchers("/universalStudent:createAcc").permitAll()
                .antMatchers("/student:authorize").permitAll()
                .antMatchers("/club/**").permitAll()
                .antMatchers("/group/**").permitAll()
                .antMatchers("/lessons/**").permitAll()
                .antMatchers( "/professor/**").permitAll()
                .antMatchers( "/student/**").permitAll()
                .antMatchers( "/studentFamily/**").permitAll()
                .antMatchers( "/universal/professor/**").permitAll()
                .antMatchers( "/universal/student/**").permitAll()
                .anyRequest().authenticated()
                .and();

        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
