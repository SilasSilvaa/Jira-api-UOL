package br.com.uol.intranet.jira.api.services;

import br.com.uol.intranet.jira.api.domain.task.TaskResponse;
import br.com.uol.intranet.jira.api.domain.task.Issue;
import br.com.uol.intranet.jira.api.repositories.JiraTaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class JiraTaskService implements JiraTaskRepository {

    private final WebClient webClient;

    @Override
    public Issue getTasks() {
        try{
            return webClient
                    .get()
                    .uri("/search?jql=project=SC&maxResults=10&startAt=0")
                    .retrieve()
                    .bodyToMono(Issue.class)
                    .block();
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public TaskResponse getTask(String task) {
        return webClient
                .get()
                .uri("/issue/" + task)
                .retrieve()
                .bodyToMono(TaskResponse.class)
                .block();
    }

}
