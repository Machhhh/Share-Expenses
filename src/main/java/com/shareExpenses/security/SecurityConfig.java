package com.shareExpenses.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
//        httpSecurity.headers().frameOptions().disable();
        http.headers().frameOptions().sameOrigin();

        http.authorizeRequests().antMatchers("/**").permitAll().and();

   /*     http.authorizeRequests()
                .antMatchers("/api**").authenticated()
                .antMatchers("/index").permitAll()
                .antMatchers("/users/login.html").permitAll()
                .anyRequest().authenticated();*/

        http.formLogin()
                .loginPage("/users/login")
                .failureHandler(
                        (req, resp, e) -> resp.sendError(HttpStatus.BAD_REQUEST.value(),
                                "Username or password invalid"))
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/users/me")
                .permitAll();

        http.logout()
                .logoutUrl("/users/logout")
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutSuccessUrl("/login.html")
                .permitAll();
    }
}