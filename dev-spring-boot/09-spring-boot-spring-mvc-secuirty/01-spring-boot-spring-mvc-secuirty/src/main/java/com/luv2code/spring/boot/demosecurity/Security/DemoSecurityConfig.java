package com.luv2code.spring.boot.demosecurity.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    // add support for JDBC NO MORE HARDCODED users

    public UserDetailsManager userDetailsManager (DataSource dataSource){

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        // define query to retrieve a user bhy username                 // how to find users
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id,pw, active from members where user_id=?"
        );

        // define query to retrieve the authorities/roles by username  // how to find roles
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id, role from roles where user_id=?"
        );

        return jdbcUserDetailsManager;
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(configurer ->
                configurer
                        // bu kısımda requestMatcherslar ile erişim kısıtlamaları ve roller vereceğiz
                        .requestMatchers("/").hasRole("EMPLOYEE")
                        .requestMatchers("/leaders/**").hasRole("MANAGER")
                        .requestMatchers("/system/**").hasRole("ADMIN")
                        .anyRequest().authenticated()    // uygulamamıza gelen herhangi bir kimliği açmış olmalıyız
                )
                .formLogin(form->
                        form
                                .loginPage("/showMyLoginPage")  // ana sayfanın gösterilmesi
                                .loginProcessingUrl("/authenticateTheUser") // kullanıcı kimliği ve doğrulamasının gercekleşmesi  //form verilerinin de gönderileceği yerdir
                                .permitAll()//herkese izin vermesi anlamına geliyor
                        )
                        .logout(logout ->logout.permitAll()

                )
                .exceptionHandling(configurer ->
                        configurer.accessDeniedPage("/access-denied"));
        return http.build();
    }

}

