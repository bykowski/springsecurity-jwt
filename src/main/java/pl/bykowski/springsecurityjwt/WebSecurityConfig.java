package pl.bykowski.springsecurityjwt;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/test2").authenticated()
                .antMatchers("/test3").hasRole("ADMIN")
                .and()
                .addFilter(new JwtFilter(authenticationManager()));
    }
}
