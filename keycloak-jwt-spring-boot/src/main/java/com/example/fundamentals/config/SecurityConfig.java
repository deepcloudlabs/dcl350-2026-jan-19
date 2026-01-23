package com.example.fundamentals.config;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

	@Bean
	SecurityFilterChain filterChain(HttpSecurity httpSecurity, JwtAuthenticationConverter jwtAuthenticationConverter)
			throws Exception {
		httpSecurity
				.authorizeHttpRequests(
						auth -> auth.requestMatchers("/public", "/swagger-ui/**", "/v3/**", "/actuator/**").permitAll()
								.anyRequest().authenticated())
				.oauth2ResourceServer(
						oauth2 -> oauth2.jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationConverter)));
		return httpSecurity.build();
	}

	@Bean
	@SuppressWarnings("unchecked")
	JwtAuthenticationConverter jwtAuthenticationConverter() {
		JwtAuthenticationConverter converter = new JwtAuthenticationConverter();

		converter.setJwtGrantedAuthoritiesConverter(jwt -> {
			if (Objects.isNull(jwt.getClaimAsMap("resource_access"))) {
				return List.of();
			}
			var rolesAsString = ((Map<String, Object>) jwt.getClaim("resource_access")).get("softtech-client")
					.toString().replace("{roles=[", "").replace("}", "").replace("]", "").replace(" ", "").split(",");
			List<GrantedAuthority> rolesWithPrefix = Arrays.stream(rolesAsString)
					.map(role -> "ROLE_" + role.toUpperCase()) // this adds the prefix!
					.map(SimpleGrantedAuthority::new).collect(Collectors.toList());
			System.err.println(rolesWithPrefix);
			return rolesWithPrefix;
		});

		return converter;
	}
}
