package org.assignment.githubapiproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Repo {

    @JsonProperty("name")
    private String repositoryName;


    @JsonProperty("owner")
    private Owner owner;

    @JsonProperty("fork")
    private boolean isFork;

    private List<Branch> branches;

    public List<Branch> getBranches() {
        return branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }

    public boolean isFork() {
        return isFork;
    }

    public void setFork(boolean fork) {
        isFork = fork;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
    }
}
