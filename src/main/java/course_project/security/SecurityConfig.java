package course_project.security;

import course_project.jwt.JwtTokenVerifier;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenVerifier jwtTokenVerifier;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/**/auth/**","/api/institutionTypes",
                        "/api/institutions/type/**","/api/categories/institution/**",
                        "/api/products/category/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin().usernameParameter("email");
        http.cors()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(jwtTokenVerifier, UsernamePasswordAuthenticationFilter.class);

    }





    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new InMemoryUserDetailsManager(
                new User("user", passwordEncoder.encode( "parol"), List.of(
                        (GrantedAuthority) () -> "ROLE_USER"
                ))
        )).passwordEncoder(passwordEncoder);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
