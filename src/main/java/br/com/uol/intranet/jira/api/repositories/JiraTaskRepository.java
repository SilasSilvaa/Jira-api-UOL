package br.com.uol.intranet.jira.api.repositories;

import br.com.uol.intranet.jira.api.domain.task.TaskResponse;
import br.com.uol.intranet.jira.api.domain.task.Issue;

public interface JiraTaskRepository {
    Issue getTasks();
    TaskResponse getTask(String task);
}
