package org.assignment.githubapiproject.client;

import org.assignment.githubapiproject.exception.UserNotFoundException;
import org.assignment.githubapiproject.model.Branch;
import org.assignment.githubapiproject.model.Repo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Component
public class GithubClient {


    private final RestTemplate rt;

    public GithubClient(RestTemplate rt){
        this.rt = rt;
    }

    public List<Repo> fetchRepositories(String usr){
        String url = UriComponentsBuilder.fromUriString("https://api.github.com")
                .path("/users/{usr}/repos")
                .buildAndExpand(usr)
                .toUriString();
            Repo[] repositories = rt.getForObject(url, Repo[].class);
            return repositories != null ? List.of(repositories) : List.of();
    }

    public List<Branch> fetchBranches(String usr, String repo){
        String url = UriComponentsBuilder.fromUriString("https://api.github.com")
                .path("/repos/{usr}/{repo}/branches")
                .buildAndExpand(usr, repo)
                .toUriString();

        Branch[] branches = rt.getForObject(url, Branch[].class);
        return branches != null ? List.of(branches) : List.of();
    }

}
