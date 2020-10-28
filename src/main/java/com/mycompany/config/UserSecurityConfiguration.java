package com.mycompany.config;

import org.jasig.cas.client.boot.configuration.EnableCasClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableCasClient
public class UserSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Value("${casLogoutUrl}")
    private String casLogoutUrl;

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/resources/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/").permitAll()
            .antMatchers("/welcome").hasAnyRole("USER", "ADMIN")
            .antMatchers("/getUsers").hasAnyRole("USER", "ADMIN")
            .antMatchers("/addUser").hasAnyAuthority("CREATOR")
            .anyRequest().authenticated()
            .and()
            .logout().logoutSuccessUrl(casLogoutUrl);

        http.csrf().disable();
    }

}
