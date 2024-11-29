package br.com.uol.intranet.jira.api.repositories;

import br.com.uol.intranet.jira.api.domain.task.TaskResponse;


public interface JiraTaskRepository {
    TaskResponse getTask(String task);
}
