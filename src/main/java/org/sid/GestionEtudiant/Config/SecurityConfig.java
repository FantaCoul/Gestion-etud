package org.sid.GestionEtudiant.Config;

import java.util.Collections;

import org.sid.GestionEtudiant.Entites.Utilisateur;
import org.sid.GestionEtudiant.Service.UtilisateurService;
import org.sid.GestionEtudiant.Service.Impl.DetailsUtilisateurServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
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
                .requestMatchers("/login", "/change-password").permitAll() // Autoriser l'accès à ces pages sans authentification
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
    @Override
    public AuthenticationManager authenticationManagerBean() {
        return super.authenticationManagerBean();
    }

    


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    public void exampleAuthentication() {
        // Notez que vous ne devriez pas utiliser directement l'AuthenticationManager de cette manière
        // Il est généralement utilisé automatiquement par Spring Security lors de l'authentification

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String motDePasseNonEncode = "mot_de_passe";
        String motDePasseEncode = encoder.encode(motDePasseNonEncode);

        // Création d'un objet Authentication
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken("nom_utilisateur", motDePasseNonEncode);

        // Obtention de l'AuthenticationManager
        AuthenticationManager authenticationManager = null;
		try {
			authenticationManager = authenticationManagerBean();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

        // Authentification
        try {
            authenticationManager.authenticate(authenticationToken);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
    }
}


