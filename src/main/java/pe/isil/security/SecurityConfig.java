package pe.isil.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pe.isil.service.ClientDetailsService;
import pe.isil.service.LoginSuccessMessage;

//import pe.isil.service.ClientDetailsService;
@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder bcryptEncoder;
    @Autowired
    private ClientDetailsService clientDetailsService;

//    private final PasswordEncoder bcryptEncoder;
//    private final UserDetailsService clientDetailsService;
//
//    @Autowired
//    public WebSecurityConfig(PasswordEncoder passwordEncoder, UserDetailsService userDetailsService) {
//        this.bcryptEncoder = passwordEncoder;
//        this.clientDetailsService = userDetailsService;
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth
                .userDetailsService(clientDetailsService)
                .passwordEncoder(bcryptEncoder);
    }

    @Autowired
    private LoginSuccessMessage successMessage;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/", "index","/css/*","/js/*", "/store", "/clients/add","/clients/save").permitAll()
                .anyRequest().authenticated().and()//.httpBasic()
                .formLogin()
                    .successHandler(successMessage)
                    .loginPage("/login").permitAll()//require get mapping
                        .defaultSuccessUrl("/store", true)
    //                    .usernameParameter("username")
    //                    .passwordParameter("password")
                .permitAll()
                .and()
                .logout()
                    .permitAll()
        ;

    }
}
