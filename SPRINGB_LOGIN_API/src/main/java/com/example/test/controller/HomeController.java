package com.example.test.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;

@Slf4j
@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model, @AuthenticationPrincipal OidcUser principal) {
        log.info("test1");
        if (principal != null) {
            model.addAttribute("name", principal.getAttribute("name"));
            log.info("test2");
            log.info("{}",principal);
        }
        return "home"; // This should map to src/main/resources/templates/home.html
    }
}