package org.assignment.githubapiproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Owner {

    @JsonProperty("login")
    private String login;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
