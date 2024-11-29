package br.com.uol.intranet.jira.api.services;

import br.com.uol.intranet.jira.api.domain.task.TaskResponse;
import br.com.uol.intranet.jira.api.repositories.JiraTaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class JiraTaskService implements JiraTaskRepository {

    private final WebClient webClient;

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
