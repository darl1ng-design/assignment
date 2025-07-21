package org.assignment.githubapiproject;

import org.assignment.githubapiproject.model.Branch;
import org.assignment.githubapiproject.model.Commit;
import org.assignment.githubapiproject.model.Owner;
import org.assignment.githubapiproject.model.Repo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GithubControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate rest;

    @Test
    void shouldReturnNonForkedReposWithBranchesAndSha() {
        // given
        String url = "http://localhost:" + port + "/api/github/repos/darl1ng-design";

         //when
        ResponseEntity<List<Repo>> response = rest.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {}
        );


        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        List<Repo> repos = response.getBody();
        assertThat(repos).isNotEmpty();

        for (Repo repo : repos) {
            assertThat(repo.isFork()).isFalse();
            assertThat(repo.getRepositoryName()).isNotBlank();

            Owner owner = repo.getOwner();
            assertThat(owner).isNotNull();
            assertThat(owner.getLogin()).isEqualTo("darl1ng-design");

            List<Branch> branches = repo.getBranches();

            for (Branch branch : branches) {
                assertThat(branch.getBranchName()).isNotBlank();

                Commit commit = branch.getCommit();
                assertThat(commit).isNotNull();
                assertThat(commit.getSha()).isNotBlank();
            }
     }

    }
}
