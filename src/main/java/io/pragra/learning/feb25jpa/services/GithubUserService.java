package io.pragra.learning.feb25jpa.services;

import io.pragra.learning.feb25jpa.entities.GithubUser;
import io.pragra.learning.feb25jpa.repo.GitUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class GithubUserService {
    @Autowired
    private GitUserRepo repo;

    @Autowired
    private RestTemplate restTemplate;

    public GithubUser fetchAndPersist(String login){
        // Rest template
        ResponseEntity<GithubUser> githubUserResponseEntity = restTemplate
                .exchange("https://api.github.com/users/" + login, HttpMethod.GET, null , GithubUser.class);
        if(Objects.nonNull(githubUserResponseEntity.getBody())
                && Objects.nonNull(githubUserResponseEntity.getBody().getId())){
            repo.save(githubUserResponseEntity.getBody());
            return githubUserResponseEntity.getBody();
        }
        return new GithubUser();
    }
}
