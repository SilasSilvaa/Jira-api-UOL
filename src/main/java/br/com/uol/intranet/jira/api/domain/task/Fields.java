package br.com.uol.intranet.jira.api.domain.task;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fields {
    private Assignee assignee;
    private Status status;
    private String description;
}