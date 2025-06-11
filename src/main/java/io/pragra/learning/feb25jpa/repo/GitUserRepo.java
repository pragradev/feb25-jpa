package io.pragra.learning.feb25jpa.repo;

import io.pragra.learning.feb25jpa.entities.GithubUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GitUserRepo extends JpaRepository<GithubUser, Integer> {
}
