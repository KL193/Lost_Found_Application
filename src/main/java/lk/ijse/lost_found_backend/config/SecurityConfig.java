package lk.ijse.lost_found_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/signup").permitAll() // ✅ Allow signup
                        .anyRequest().authenticated() // 🔒 Other endpoints require auth
                );
        return http.build();
    }
}
