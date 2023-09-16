package dev.eklak.springoauth2.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    /*
    // This is a second approach to add the information about the client registration and
    // ClientRegistrationRepository
    @Value("${spring.oauth2.client-id}")
    private String clientId;

    @Value("${spring.oaut2.client-secret}")
    private String clientSecret;

    // Bean  contains the reference of the client registration
    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        var clientRegistration = clientRegistration();
        return new InMemoryClientRegistrationRepository(clientRegistration);
    }

    private ClientRegistration clientRegistration() {
        return CommonOAuth2Provider.GITHUB
            .getBuilder("github")
            .clientId(clientId)
            .clientSecret(clientSecret)
            .build();
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Sets the authentication method
        // It simply adds the new authentication filter to the filter chain
        // Adds OAuth2LoginAuthenticationFilter to the filter chain
        // filter intercepts requests and applies the needed logic for OAuth 2
        //authentication
        http.oauth2Login();

        // Specifies that user needs to be authenticated to make the request
        http.authorizeRequests().anyRequest().authenticated();
    }
}
