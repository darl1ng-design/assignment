package org.assignment.githubapiproject.controller;


import org.assignment.githubapiproject.model.Repo;
import org.assignment.githubapiproject.service.GithubService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/github")
public class GithubController {

    private final GithubService gs;

    public GithubController(GithubService gs) {
        this.gs = gs;
    }


    @GetMapping("/repos/{user}")
    public ResponseEntity<List<Repo>> getUserRepositories(@PathVariable String user){
        List<Repo> repos = gs.fetchUserRepos(user);
        return ResponseEntity.ok(repos);
    }
}
