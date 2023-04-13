package com.infy.workflixbackend2.security;

import com.infy.workflixbackend2.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private JwtTokenFilter jwtTokenFilter;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/v3/api-docs/**",
                "/configuration/ui",
                "/swagger-resources",
                "/configuration/security",
                "/swagger-ui.html",
                "/webjars/**",
                "/swagger-resources/configuration/ui",
                "/swagger-ui.html",
                "/swagger-ui/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(
                username -> loginRepository.findById(username)
                        .orElseThrow(
                                () -> new UsernameNotFoundException("User " + username + "not found")));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests().antMatchers("/auth/login","/login-api/register").permitAll().anyRequest().authenticated();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.cors();
        http.csrf().disable();
        http.exceptionHandling()
                .authenticationEntryPoint(
                        (request, response, ex) -> {
                            response.sendError(
                                    HttpServletResponse.SC_UNAUTHORIZED,
                                    ex.getMessage()
                            );
                        }
                );

        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }


    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


}
