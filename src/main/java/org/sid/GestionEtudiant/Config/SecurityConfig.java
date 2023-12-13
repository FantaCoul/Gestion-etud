package org.sid.GestionEtudiant.Config;

import java.util.Collections;

import org.sid.GestionEtudiant.Entites.Utilisateur;
import org.sid.GestionEtudiant.Service.UtilisateurService;
import org.sid.GestionEtudiant.Service.Impl.DetailsUtilisateurServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final DetailsUtilisateurServiceImpl userDetailsService;

    public SecurityConfig(DetailsUtilisateurServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
                .requestMatchers("/public/**",  "/change-password").permitAll() // Autoriser l'accès à ces pages sans authentification
                .anyRequest().authenticated()
            .and()
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/dashboard") // Redirection après une connexion réussie
                .permitAll()
            .and()
            .logout()
                .logoutSuccessUrl("/login") // Redirection après une déconnexion réussie
                .permitAll();
    }

    // Ajoutez votre gestionnaire d'authentification et encodeur ici

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().requestMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }


 // SecurityConfig.java
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder());
      

         }

    


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}


