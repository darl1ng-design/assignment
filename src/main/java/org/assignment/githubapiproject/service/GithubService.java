package org.assignment.githubapiproject.service;

import org.assignment.githubapiproject.client.GithubClient;
import org.assignment.githubapiproject.model.Branch;
import org.assignment.githubapiproject.model.Repo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GithubService {

    private final GithubClient client;

    public GithubService(GithubClient client) {
        this.client = client;

    }

    public List<Repo> fetchUserRepos(String user){
        List<Repo> userRepos = client.fetchRepositories(user);

        return userRepos.stream()
                .filter(repo -> !repo.isFork())
                .peek(repo -> {
                    List<Branch> branches = client.fetchBranches(user, repo.getRepositoryName());
                    repo.setBranches(branches);
                })
                .toList();
    }
}
