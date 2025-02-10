package lt.techin.movie_studio_71.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//    http.csrf(Customizer.withDefaults())
    http.csrf(c -> c.disable())
            .httpBasic(Customizer.withDefaults())
            .authorizeHttpRequests(authorize -> authorize
                    .requestMatchers(HttpMethod.GET, "/api/movies").hasRole("USER")
                    .requestMatchers(HttpMethod.GET, "/api/movies/{id}").hasRole("USER")
                    .requestMatchers(HttpMethod.POST, "/api/movies").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.POST, "/api/users").permitAll()
                    .requestMatchers(HttpMethod.GET, "/api/users").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.GET, "/api/users/{id}").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/api/users/{id}").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/api/users/{id}").hasRole("ADMIN")
                    .anyRequest().authenticated()
            );

    return http.build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
