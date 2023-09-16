package dev.eklak.springoauth2.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    private final Logger logger = LoggerFactory.getLogger(MainController.class.getName());

    // Spring Boot automatically injects the Authentication object
    // representing the user in the method's parameter
    @GetMapping("/")
    public String main(OAuth2AuthenticationToken token) {
        logger.info("Authenticated user: " + token.getPrincipal());
        return "main.html";
    }
}
