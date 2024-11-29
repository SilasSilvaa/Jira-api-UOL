package br.com.uol.intranet.jira.api.controllers;

import br.com.uol.intranet.jira.api.domain.task.TaskResponse;
import br.com.uol.intranet.jira.api.domain.task.Issue;
import br.com.uol.intranet.jira.api.services.JiraTaskService;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("jira/issue")
@RequiredArgsConstructor
public class TaskController {

    private final JiraTaskService jiraService;

    @GetMapping("/{task}")
    public ResponseEntity<TaskResponse> getTask(@PathVariable @NotBlank String task){
        TaskResponse data = jiraService.getTask(task);
        return ResponseEntity.ok(data);
    }

    @GetMapping
    public ResponseEntity<Issue> getTasks(){
        return ResponseEntity.ok(jiraService.getTasks());
    }
}
