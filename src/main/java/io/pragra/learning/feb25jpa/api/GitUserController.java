package io.pragra.learning.feb25jpa.api;

import io.pragra.learning.feb25jpa.entities.GithubUser;
import io.pragra.learning.feb25jpa.services.GithubUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gituser")
public class GitUserController {
    @Autowired
    private GithubUserService service;

    @GetMapping("/fetch")
    public GithubUser fetchUser(@RequestParam String username){
        return service.fetchAndPersist(username);
    }
}
