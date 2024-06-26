package pl.pingwit.pingwitcarrental.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    public static final String USER_ROLE = "USER";
    public static final String ADMIN_ROLE = "ADMIN";

    @Bean
    public UserDetailsService users() {
        User.UserBuilder users = User.withDefaultPasswordEncoder();

        UserDetails user = users
                .username("user1")
                .password("user1")
                .roles(USER_ROLE)
                .build();

        UserDetails user2 = users
                .username("user2")
                .password("user2")
                .build();

        UserDetails admin = users
                .username("admin")
                .password("admin")
                .roles(ADMIN_ROLE, USER_ROLE)
                .build();
        return new InMemoryUserDetailsManager(user, admin, user2);
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .httpBasic(withDefaults())
                .cors(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers(HttpMethod.POST, "/car", "/client", "/rental-center").hasRole(ADMIN_ROLE)
                        .requestMatchers(HttpMethod.DELETE, "/car", "/client", "/rental-center").hasRole(ADMIN_ROLE)
                        .requestMatchers(HttpMethod.GET, "/client").hasRole(ADMIN_ROLE)
                        .requestMatchers(HttpMethod.GET, "/car", "/car/**", "/client/**", "/rental-center",
                                "/rental-center/**", "/rental-order", "/rental-order/**").hasAnyRole(ADMIN_ROLE, USER_ROLE)
                        .requestMatchers(HttpMethod.POST, "/rental-order").hasRole(USER_ROLE)
                        .requestMatchers("/swagger-ui", "/swagger-ui/**", "/api-docs/**").permitAll()
                        .anyRequest().authenticated()
                );
        return http.build();
    }

}
